package com.microsoft.tencentnews.modules.activitys;

import android.content.Intent;
import android.os.Bundle;

import com.microsoft.tencentnews.R;

public class SplashActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //1:启动页面，休眠5秒跳转到MainActivity
        initlise();
    }


    private void initlise(){

        //SystemClock.sleep(3000);
        this.startActivity(new Intent(this,MainActivity.class));
        this.finish();
    }
}
