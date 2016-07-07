package com.microsoft.tencentnews.modules.fragment_aboutme.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutMeFragment extends BaseFragment{

    private Context context;

    @Override
    protected int setViewID(){
        return R.layout.fragment_aboutme;
    }

    @Override
    protected void findViews(View mView){
    }

    @Override
    protected void initData(){
    }

    @Override
    protected void initEvent(){
    }

    @Override
    protected void loadData(){
    }

    @Override
    protected void obtainContext(Context context){
        this.context = context;
    }
}
