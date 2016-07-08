package com.microsoft.tencentnews.modules.fragment_recommend.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.common.adapter.Recommend_Adapter;
import com.microsoft.tencentnews.common.adapter.RecycelViewDecorator;
import com.microsoft.tencentnews.common.constante.Constante;
import com.microsoft.tencentnews.common.net.HttpUtils;
import com.microsoft.tencentnews.common.utils.UtilsAssets;
import com.microsoft.tencentnews.modules.fragment_recommend.bean.MainNewsBean;
import com.microsoft.tencentnews.modules.fragment_recommend.bean.NewsBeanRecommend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecomendFragment extends BaseFragment{

    private Context mycontext;
    private SwipeRefreshLayout mySwipeRefreshLayout;
    private RecyclerView myRecycleView;
    private List<NewsBeanRecommend> strlist=new ArrayList<>();
    private List<String> interfaceList;
    private static int page;
    MainNewsBean mainNewsBean=new MainNewsBean();
    private Handler myHandler;

    @Override
    protected int setViewID(){
        return R.layout.fragment_recomend;
    }

    @Override
    protected void findViews(View mView){
        mySwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swiperefreshlayout_recommend);
        myRecycleView = (RecyclerView) mView.findViewById(R.id.recycleview_recommend);
    }

    @Override
    protected void initData(){
        HashMap<String, List<String>> interfaceUrlMap = UtilsAssets.getInterfaceUrlMap(mycontext, "recommendinterface");
        interfaceList = interfaceUrlMap.get("recommend_interface.txt");










    }

    @Override
    protected void initEvent(){


        mySwipeRefreshLayout.setColorSchemeColors(R.color.color1,R.color.color2,R.color.color3,R.color.color4);
        mySwipeRefreshLayout.setProgressViewOffset(true,0,24);
        mySwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                //刷新

            }
        });
        final LinearLayoutManager manager = new LinearLayoutManager(mycontext,LinearLayoutManager.VERTICAL,false);
        myRecycleView.setLayoutManager(manager);
        myRecycleView.addItemDecoration(new RecycelViewDecorator(mycontext,0));
        myRecycleView.setItemAnimator(new DefaultItemAnimator());
        final Recommend_Adapter recommendAdapter = new Recommend_Adapter(mycontext,strlist);
        myRecycleView.setAdapter(recommendAdapter);

        myHandler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);

                if(msg.what == Constante.HANDLER_SUCCESS){
                    MainNewsBean newsbean = (MainNewsBean) msg.obj;

                    List<NewsBeanRecommend> nbrList=newsbean.getNewslist();

                    strlist.addAll(nbrList);

                    recommendAdapter.notifyDataSetChanged();




                }else {


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


                int passCount=manager.findFirstCompletelyVisibleItemPosition();
                int currentCount = manager.getChildCount();
                int allCount = manager.getItemCount();

                if(passCount+currentCount >= allCount){

                    //刷新





                }




            }
        });




    }

    @Override
    protected void loadData(){


        interfaceList.size();

        page=0;


        new Thread(new Runnable(){


            @Override
            public void run(){
                String jsonUrlStr = interfaceList.get(page);
                String jsonStr = HttpUtils.downLoadJson(mycontext, jsonUrlStr);
                MainNewsBean mainnews = HttpUtils.parseJson(mainNewsBean, jsonStr);

                if(mainnews != null){


                    Message message = myHandler.obtainMessage();
                    message.what=Constante.HANDLER_SUCCESS;

                    message.obj=mainnews;

                    myHandler.sendMessage(message);


                }





            }
        }).start();


    }

    @Override
    protected void obtainContext(Context context){
        mycontext = context ;
    }




}
