package com.microsoft.tencentnews.modules.splashactivity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseActivity;
import com.microsoft.tencentnews.modules.mainactivity.ui.MainActivity;

public class SplashActivity extends BaseActivity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(setViewID());
       // initEvent();



    }


    @Override
    protected int setViewID(){
        return R.layout.activity_splash;

    }

    @Override
    protected void findViews(){
    }

    @Override
    protected void initData(){
    }

    @Override
    protected void initEvent(){
        //SystemClock.sleep(3000);
        this.startActivity(new Intent(this,MainActivity.class));
        this.finish();
    }


    @Override
    protected void loadData(){
    }

}
