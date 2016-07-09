package com.microsoft.tencentnews.modules.fragment_live.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.common.adapter.LiveRecycleAdapter;
import com.microsoft.tencentnews.common.adapter.RecycelViewDecorator;
import com.microsoft.tencentnews.common.net.HttpUtils;
import com.microsoft.tencentnews.common.utils.UtilsAssets;
import com.microsoft.tencentnews.modules.fragment_live.bean.NewsBeanLive;
import com.microsoft.tencentnews.modules.fragment_live.bean.SubNewsBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends BaseFragment{

    private Context mycontext;
    private RecyclerView recyclerView;
    private List<SubNewsBean> subNewsBeanList = new ArrayList<>();
    private static int pageNum=0;
    private static int listNum=10;
    private LiveRecycleAdapter adapter;

    @Override
    protected int setViewID(){
        return R.layout.fragment_live;
    }

    @Override
    protected void findViews(View mView){
        recyclerView = (RecyclerView) mView.findViewById(R.id.recycleView_live);
    }

    @Override
    protected void initData(){
        loadDataStep(pageNum, listNum);
    }

    @Override
    protected void initEvent(){
        adapter = new LiveRecycleAdapter(mycontext,subNewsBeanList);
        LinearLayoutManager manager = new LinearLayoutManager(mycontext, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        RecycelViewDecorator decor = new RecycelViewDecorator(mycontext, 0);
        recyclerView.addItemDecoration(decor);
        recyclerView.setAdapter(adapter);




    }

    @Override
    protected void loadData(){


    }

    @Override
    protected void obtainContext(Context context){
        mycontext = context ;
    }


    //

    public void loadDataStep(final int pageCount, final int listCount){
        new Thread(new Runnable(){
            @Override
            public void run(){
                HashMap<String, List<String>> liveinterfaceMap = UtilsAssets.getInterfaceUrlMap(mycontext, "liveinterface");
                List<String> liveinterfaceList = liveinterfaceMap.get("live_interface.txt");
                String liveUrl = liveinterfaceList.get(0);
                //http://c.3g.163.com/nc/video/list/V9LG4B3A0/n/10-10.html
                String baseUrl = liveUrl.substring(0, liveUrl.lastIndexOf("\\/") + 1);
                String url = baseUrl + pageCount + "-" + listCount + ".html";
                String jsonStr = HttpUtils.downLoadJson(mycontext, url);
                NewsBeanLive newsBeanLive = HttpUtils.parseJson(new NewsBeanLive(), jsonStr);
                final List<SubNewsBean> subList = newsBeanLive.getV9LG4B3A0();
                recyclerView.post(new Runnable(){
                    @Override
                    public void run(){
                        subNewsBeanList.addAll(subList);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }



}
