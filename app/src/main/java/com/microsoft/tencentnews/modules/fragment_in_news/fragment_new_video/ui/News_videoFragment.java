package com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_video.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.common.adapter.RecycelViewDecorator;
import com.microsoft.tencentnews.common.adapter.RecycleViewAdapter_news_video;
import com.microsoft.tencentnews.common.constante.Constante;
import com.microsoft.tencentnews.common.net.HttpUtils;
import com.microsoft.tencentnews.common.utils.UtilsAssets;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_video.bean.NewsBean_news_video;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_video.bean.SubNewsBean_news_video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class News_videoFragment extends BaseFragment{

    private Context context;
    private RecyclerView ryView;
    private SwipeRefreshLayout srefreshLayout;
    private int pageNumVideo=0;

    private Handler myHandler;
    private List<String> videoUrlList;

    private List<SubNewsBean_news_video> sublist=new ArrayList<>();
    private RecycleViewAdapter_news_video adapter;
    private LinearLayoutManager manager;
    private RecycelViewDecorator decorator;

    @Override
    protected int setViewID(){
        return R.layout.fragment_news_video;
    }

    @Override
    protected void findViews(View myView){
        ryView = (RecyclerView) myView.findViewById(R.id.recycleView_new_video);
        srefreshLayout = (SwipeRefreshLayout) myView.findViewById(R.id.swiperefreshlayout_news_video);





    }

    @Override
    protected void initData(){
        HashMap<String, List<String>> newsinterfaceMap = UtilsAssets.getInterfaceUrlMap(context, "newsinterface");
        videoUrlList = newsinterfaceMap.get("video_interface.txt");
        adapter = new RecycleViewAdapter_news_video(context,sublist);
        manager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        decorator = new RecycelViewDecorator(context,0);
        ryView.setLayoutManager(manager);
        ryView.addItemDecoration(decorator);
        ryView.setAdapter(adapter);




    }

    @Override
    protected void initEvent(){


        srefreshLayout.setProgressViewOffset(true,0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,24,getResources().getDisplayMetrics()));
        srefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                loadDataStep(0);
                srefreshLayout.setRefreshing(false);
            }
        });

        ryView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState){
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                super.onScrolled(recyclerView, dx, dy);
                int passNum = manager.findFirstCompletelyVisibleItemPosition();
                int currentNum = manager.getChildCount();
                int allNum = manager.getItemCount();
                if(passNum + currentNum >= allNum){
                    loadDataStep(++passNum);
                }
            }
        });


        myHandler = new Handler(){

            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);


                switch(msg.what){
                    case Constante.HANDLER_SUCCESS:
                        NewsBean_news_video newsBean = (NewsBean_news_video) msg.obj;
                        List<SubNewsBean_news_video> subnewslist = newsBean.getNewslist();
                        sublist.addAll(subnewslist);
                        adapter.notifyDataSetChanged();
                          break;
                    case Constante.HANDLER_ERROR:
                        break;
                }
            }
        };





    }

    @Override
    protected void loadData(){

        loadDataStep(pageNumVideo);
    }

    @Override
    protected void obtainContext(Context context){

        this.context=context;
    }



    //
    private void loadDataStep(final int pageNum){


        new Thread(new Runnable(){
            @Override
            public void run(){
                String jsonStr = HttpUtils.downLoadJson(context,videoUrlList .get(pageNum));
                NewsBean_news_video newsBean = HttpUtils.parseJson(new NewsBean_news_video(), jsonStr);

                if(newsBean != null){
                    Message message = myHandler.obtainMessage();

                    message.what= Constante.HANDLER_SUCCESS;
                    message.obj=newsBean;
                    myHandler.sendMessage(message);


                }else {


                    myHandler.sendEmptyMessage(Constante.HANDLER_ERROR);
                }



            }
        }).start();








    }
}
