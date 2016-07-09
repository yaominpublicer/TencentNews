package com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_news.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.common.adapter.News_newsAdapter;
import com.microsoft.tencentnews.common.adapter.RecycelViewDecorator;
import com.microsoft.tencentnews.common.constante.Constante;
import com.microsoft.tencentnews.common.net.HttpUtils;
import com.microsoft.tencentnews.common.utils.UtilsAssets;
import com.microsoft.tencentnews.modules.activity_news_detail.Activity_News_Details;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_news.bean.NewsBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class News_newsFragment extends BaseFragment{

    private RecyclerView recyclerView;

    private List<String> newsList;

    private final NewsBean nb = new NewsBean();

    private final List<NewsBean.NewsContent> nclist = new ArrayList<>();

    private Context mycontext;
    private static int page;
    private Handler myHandler;

    @Override
    protected int setViewID(){
        return R.layout.fragment_news_news;
    }

    @Override
    protected void findViews(View myView){
        recyclerView = (RecyclerView) myView.findViewById(R.id.recycelView_news_news);
    }

    @Override
    protected void initData(){
        //1:initData

        //1:获取news fragment 下各个页面的接口数据list
        // :因为接口是抓取的 无法获取接口 根URL只能抓取各个页面的 单一页数据，所以分别抓取放在assets中来读取

        HashMap<String, List<String>> newsinterfaceMap = UtilsAssets.getInterfaceUrlMap(mycontext, "newsinterface");
        newsList = newsinterfaceMap.get("news_interface.txt");
        //1:根据接口数据下载
        //
        page = 0;
        recycleViewStepLoad(page);

    }

    @Override
    protected void initEvent(){

        //2:adapter
        final News_newsAdapter adapter = new News_newsAdapter(mycontext, nclist);
        //3:setadapter
        final LinearLayoutManager manager = new LinearLayoutManager(mycontext, LinearLayoutManager.VERTICAL, false);
        RecycelViewDecorator decorator = new RecycelViewDecorator(mycontext, 0);
        recyclerView.addItemDecoration(decorator);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        //setAdapter
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState){
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    int lastPosition = manager.findLastVisibleItemPosition();
                    if(lastPosition >= adapter.getItemCount() - 1){
                        // loadmore
                        if(page < newsList.size()){
                            page++;
                            recycleViewStepLoad(page);
                        }
                    }
                }
            }


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                super.onScrolled(recyclerView, dx, dy);
            }
        });


       adapter.setOnRecycleViewItemClickListener(new News_newsAdapter.OnRecycleViewItemClickListener(){
           @Override
           public void itemClick(View v, String url){
               Intent intent = new Intent();
               intent.setClass(mycontext, Activity_News_Details.class);
               intent.putExtra("url",url);

               startActivity(intent);



           }
       });





        myHandler = new Handler(){

            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                switch(msg.what){
                    case Constante.HANDLER_SUCCESS:
                        List<NewsBean.NewsContent> newsContentList = ((NewsBean) msg.obj).getNewslist();
                        Log.e("handler", "handleMessage: " + newsContentList.size());
                        nclist.addAll(newsContentList);
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
        // 先解析第一页
    }

    @Override
    protected void obtainContext(Context context){
        mycontext = context;
    }

    public void recycleViewStepLoad(int pagenum){
        final String url = newsList.get(pagenum);
        new Thread(new Runnable(){
            @Override
            public void run(){
                NewsBean newsBean;
                String jsonStr = HttpUtils.downLoadJson(mycontext, url);
                newsBean = HttpUtils.parseJson(nb, jsonStr);
                if(newsBean != null){
                    Message message = myHandler.obtainMessage();
                    message.what = Constante.HANDLER_SUCCESS;
                    message.obj = newsBean;
                    int num = newsBean.getNewslist().size();
                   // Log.e("thread", "rum: --------" + num);
                    myHandler.sendMessage(message);
                }
            }
        }).start();
    }
}
