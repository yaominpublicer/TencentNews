package com.microsoft.tencentnews.base;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.microsoft.tencentnews.common.utils.UtilsAssets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public abstract class BaseFragment extends Fragment{

    Context mycontext ;


    private List<String> army_interfaceList;
    private List<String> car_interfaceList;
    private List<String> culture_interfaceList;
    private List<String> digital_interfaceList;
    private List<String> entertaimentList;
    private List<String> fashionList;
    private List<String> filmsList;
    private List<String> financeList;
    private List<String> imageList;
    private List<String> nbaList;
    private List<String> newsList;
    private List<String> societyList;
    private List<String> sportList;
    private List<String> technologyList;
    private List<String> videoList;
    private HashMap<String, List<String>> interfaceUrlMap = new HashMap<>();

    @Nullable
    @Override
    public  View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View myView=inflater.inflate(setViewID(),container,false);

        //5:
        mycontext = getActivity();
        obtainContext(mycontext);

        //1:find all views
        findViews(myView);
        //2:new object
        initData();
        //3:set listener
        initEvent();
        //4:net work
        loadData();




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
        army_interfaceList = interfaceUrlMap.get("army_interface.txt");
        car_interfaceList = interfaceUrlMap.get("car_interface.txt");
        culture_interfaceList = interfaceUrlMap.get("culture_interface.txt");
        digital_interfaceList = interfaceUrlMap.get("digital_interface.txt");
        entertaimentList = interfaceUrlMap.get("entertaiment_interface.txt");
        fashionList = interfaceUrlMap.get("fashion_interface.txt");
        filmsList = interfaceUrlMap.get("films_interface.txt");
        financeList = interfaceUrlMap.get("finance_interface.txt");
        imageList = interfaceUrlMap.get("image_interface.txt");
        nbaList = interfaceUrlMap.get("nba_interface.txt");
        newsList = interfaceUrlMap.get("news_interface.txt");
        societyList = interfaceUrlMap.get("society_interface.txt");
        sportList = interfaceUrlMap.get("sport_interface.txt");
        technologyList = interfaceUrlMap.get("technology_interface.txt");
        videoList = interfaceUrlMap.get("video_interface.txt");







        return myView;

    }


    protected abstract int setViewID();

    protected abstract void findViews(View myView);

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract void loadData();

    protected abstract void obtainContext(Context context);






}
