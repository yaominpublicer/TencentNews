package com.microsoft.tencentnews.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 16-7-5.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(setViewID());


        //1:find all views
        findViews();

        //2:new object
        initData();

        //3:initEvent set listener
        initEvent();

        //4:load data  net work
        loadData();


    }


    protected abstract int setViewID();

    protected abstract void findViews();

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract void loadData();
}
