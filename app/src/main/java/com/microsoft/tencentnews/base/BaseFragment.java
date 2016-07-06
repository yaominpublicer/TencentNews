package com.microsoft.tencentnews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment{

    @Nullable
    @Override
    public  View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View myView=inflater.inflate(setViewID(),container,false);

        //1:find all views
        findViews(myView);
        //2:new object
        initData();
        //3:set listener
        initEvent();
        //4:net work
        loadData();




        return myView;

    }


    protected abstract int setViewID();

    protected abstract void findViews(View myView);

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract void loadData();





}
