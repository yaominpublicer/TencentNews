package com.microsoft.tencentnews.modules.fragments;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.utils.UtilsAssets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment{

    private String TAG="NewsFragment";
    private View newsView;
    private TabLayout itemTabLayout;
    private ViewPager viewPage_news;
    private HashMap<String , List<String>> interfaceMap=new HashMap<>();


    public NewsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        newsView = inflater.inflate(R.layout.fragment_news, container, false);
        return newsView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){


        //1:newsView.findViewByID();
        findView(view);

        //2:initialise data

        initData();

        //3:




    }

    private void initData(){
        AssetManager assetManager = getResources().getAssets();
        try{
            String[] fileList = assetManager.list("newsinterface");
            for(int i = 0; i < fileList.length; i++){
                List<String> interfaceList = UtilsAssets.getInterfaceFromAssets(assetManager, "newsinterface/" + fileList[i]);
                //interfaceMap 存news模块不同页面的接口；k=文件名，v=接口字符串；
                interfaceMap.put(fileList[i], interfaceList);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    private void findView(View view){
        itemTabLayout = (TabLayout) view.findViewById(R.id.tabLayout_news);
        viewPage_news = (ViewPager) view.findViewById(R.id.viewPager_news);

    }
}
