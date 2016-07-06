package com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_news.ui;



import android.content.res.AssetManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.common.adapter.News_newsAdapter;
import com.microsoft.tencentnews.common.utils.UtilsAssets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class News_newsFragment extends BaseFragment{


    private RecyclerView recyclerView;
    private HashMap<String , List<String>> interfaceUrlMap=new HashMap<>();

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
        AssetManager assetManager = getResources().getAssets();
        try{
            String[] fileList = assetManager.list("newsinterface");
            for(int i = 0; i < fileList.length; i++){
                List<String> interfaceList = UtilsAssets.getInterfaceFromAssets(assetManager, "newsinterface/" + fileList[i]);
                //interfaceMap 存news模块不同页面的接口；k=文件名，v=接口字符串；
                if(interfaceList != null){
                    interfaceUrlMap.put(fileList[i], interfaceList);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }



        //1:获取news fragment 下各个页面的接口数据list
        // :因为接口是抓取的 无法获取接口 根URL只能抓取各个页面的 单一页数据，所以分别抓取放在assets中来读取
        List<String> army_interfaceList = interfaceUrlMap.get("army_interface.txt");
        List<String> car_interfaceList = interfaceUrlMap.get("car_interface.txt");
        List<String> culture_interfaceList = interfaceUrlMap.get("culture_interface.txt");
        List<String> digital_interfaceList = interfaceUrlMap.get("digital_interface.txt");
        List<String> entertaimentList = interfaceUrlMap.get("entertaiment_interface.txt");
        List<String> fashionList = interfaceUrlMap.get("fashion_interface.txt");
        List<String> filmsList = interfaceUrlMap.get("films_interface.txt");
        List<String> financeList = interfaceUrlMap.get("finance_interface.txt");
        List<String> imageList = interfaceUrlMap.get("image_interface.txt");
        List<String> nbaList = interfaceUrlMap.get("nba_interface.txt");
        List<String> newsList = interfaceUrlMap.get("news_interface.txt");
        List<String> societyList = interfaceUrlMap.get("society_interface.txt");
        List<String> sportList = interfaceUrlMap.get("sport_interface.txt");
        List<String> technologyList = interfaceUrlMap.get("technology_interface.txt");
        List<String> videoList = interfaceUrlMap.get("video_interface.txt");



        //2:adapter
        List<String> list=new ArrayList<>();
        for(int i = 0; i < 50; i++){

            list.add("title and comment in recycle view "+i);

        }


        News_newsAdapter adapter = new News_newsAdapter(getActivity(),list);





        //3:setadapter
        LinearLayoutManager manager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);




    }

    @Override
    protected void initEvent(){
    }

    @Override
    protected void loadData(){
    }
}
