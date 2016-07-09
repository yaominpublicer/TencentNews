package com.microsoft.tencentnews.modules.fragment_recommend.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.common.adapter.Recommend_Adapter;
import com.microsoft.tencentnews.common.adapter.RecycelViewDecorator;
import com.microsoft.tencentnews.common.constante.Constante;
import com.microsoft.tencentnews.common.net.HttpUtils;
import com.microsoft.tencentnews.common.utils.UtilsAssets;
import com.microsoft.tencentnews.modules.activity_news_detail.Activity_News_Details;
import com.microsoft.tencentnews.modules.fragment_recommend.bean.MainNewsBean;
import com.microsoft.tencentnews.modules.fragment_recommend.bean.NewsBeanRecommend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecomendFragment extends BaseFragment implements View.OnClickListener{

    private Context mycontext;
    private SwipeRefreshLayout mySwipeRefreshLayout;
    private RecyclerView myRecycleView;
    private List<NewsBeanRecommend> strlist=new ArrayList<>();
    private List<String> interfaceList;
    private static int page=0;
    MainNewsBean mainNewsBean=new MainNewsBean();
    private Handler myHandler;
    private RelativeLayout footView;
    private AlphaAnimation alphaAnimation;

    private ImageView more_recommend;
    private Button recommendButton_recommend;

    @Override
    protected int setViewID(){
        return R.layout.fragment_recomend;
    }

    @Override
    protected void findViews(View mView){
        mySwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swiperefreshlayout_recommend);
        myRecycleView = (RecyclerView) mView.findViewById(R.id.recycleview_recommend);
        footView = (RelativeLayout) mView.findViewById(R.id.progressbar_footview_recommend);
        more_recommend = (ImageView) mView.findViewById(R.id.more_recommend);
        recommendButton_recommend = (Button) mView.findViewById(R.id.recommendText_recommend);

    }

    @Override
    protected void initData(){
        HashMap<String, List<String>> interfaceUrlMap = UtilsAssets.getInterfaceUrlMap(mycontext, "recommendinterface");
        interfaceList = interfaceUrlMap.get("recommend_interface.txt");


        alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setStartOffset(1000);








    }

    @Override
    protected void initEvent(){
        mySwipeRefreshLayout.setColorSchemeResources(R.color.color1, R.color.color2, R.color.color3, R.color.color4);
        mySwipeRefreshLayout.setProgressViewOffset(true,0,18);

        mySwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                //刷新 the first page
                loadDataByPageStep(0);
            }
        });
        final LinearLayoutManager manager = new LinearLayoutManager(mycontext, LinearLayoutManager.VERTICAL, false);
        myRecycleView.setLayoutManager(manager);
        myRecycleView.addItemDecoration(new RecycelViewDecorator(mycontext, 0));
        myRecycleView.setItemAnimator(new DefaultItemAnimator());
        final Recommend_Adapter recommendAdapter = new Recommend_Adapter(mycontext, strlist);
        myRecycleView.setAdapter(recommendAdapter);
        myHandler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                if(msg.what == Constante.HANDLER_SUCCESS){
                    MainNewsBean newsbean = (MainNewsBean) msg.obj;
                    List<NewsBeanRecommend> nbrList = newsbean.getNewslist();
                    Log.e("recommend", "nbrList.size:----" + nbrList.size() + "-----");
                    strlist.addAll(nbrList);
                    recommendAdapter.notifyDataSetChanged();
                }else{
                }
            }
        };
        myRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState){
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                super.onScrolled(recyclerView, dx, dy);
                int passCount = manager.findFirstCompletelyVisibleItemPosition();
                int currentCount = manager.getChildCount();
                int allCount = manager.getItemCount();
                if(passCount + currentCount >= allCount){
                    //刷新

                    footView.startAnimation(alphaAnimation);
                    loadDataByPageStep(++page);

                }
            }
        });

        recommendAdapter.SetOnReCycleViewItemClickListener02(new Recommend_Adapter.OnRecycleViewItemClickListener02(){
            @Override
            public void itemClick(View v, String url){
                Intent intent = new Intent(mycontext, Activity_News_Details.class);
                intent.putExtra("url",url);

                startActivity(intent);



            }
        });


        more_recommend.setOnClickListener(this);
        recommendButton_recommend.setOnClickListener(this);



    }

    @Override
    protected void loadData(){



            loadDataByPageStep(page);



    }



    @Override
    protected void obtainContext(Context context){
        mycontext = context ;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }



    private void loadDataByPageStep(final int pageNum){


        if(pageNum>=interfaceList.size()){

            throw  new IllegalArgumentException("-----the page is out of boundary-----");

        }else{
            new Thread(new Runnable(){

                @Override
                public void run(){
                    String jsonUrlStr = interfaceList.get(pageNum);
                    String jsonStr = HttpUtils.downLoadJson(mycontext, jsonUrlStr);
                    MainNewsBean mainnews = HttpUtils.parseJson(mainNewsBean, jsonStr);
                    Log.e("recommend", "--------------------mainnews--------------------");
                    if(mainnews != null){
                        Message message = myHandler.obtainMessage();
                        message.what = Constante.HANDLER_SUCCESS;
                        message.obj = mainnews;
                        myHandler.sendMessage(message);
                    }
                }
            }).start();
        }
    }

    @Override
    public void onClick(View v){

        switch(v.getId()){

            case R.id.more_recommend:
                Toast.makeText(mycontext, "  more ", Toast.LENGTH_SHORT).show();

                break;

            case R.id.recommendText_recommend:
                Toast.makeText(mycontext, "  recommend ", Toast.LENGTH_SHORT).show();
                break;
        }





    }
}
