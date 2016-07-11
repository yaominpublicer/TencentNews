package com.microsoft.tencentnews.modules.activity_videoplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.modules.activity_login.ui.LoginRegisterActivity;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class ActivityVideoPlay extends AppCompatActivity implements View.OnClickListener{

    //because this need to initialise vitamio then no to extends base activity
    private VideoView videoView;
    private MediaController mediaController;
    private ImageView weixin;
    private ImageView qzone;
    private ImageView qq;
    private ImageView sina;
    private TextView playCount;
    private RecyclerView commentRecycleView;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(!io.vov.vitamio.LibsChecker.checkVitamioLibs(this)){
            return;
        }

        setContentView(setViewID());

        findViews();
        initData();
        initEvent();
        loadData();

    }


    private int setViewID(){
        return R.layout.activity_video_play;
    }


    private void findViews(){
        videoView = (VideoView) findViewById(R.id.surfaceView_videoPlay);
        weixin = (ImageView) findViewById(R.id.weichat_videoplayActivity);
        qzone = (ImageView) findViewById(R.id.qzone_videoplayActivity);
        qq = (ImageView) findViewById(R.id.qq_videoplayActivity);
        sina = (ImageView) findViewById(R.id.sina_videoplayActivity);
        playCount = (TextView) findViewById(R.id.playCount_videoActivity);
        commentRecycleView = (RecyclerView) findViewById(R.id.commentRecycleView_videoActivity);
        progressBar = (ProgressBar) findViewById(R.id.progressbar_videoActivity);
    }


    private void initData(){

        String videoPath=getIntent().getStringExtra("url");
        if(videoPath == null){
            videoPath="http://220.181.23.202/s1/UvFuJjXR07s7t1nO/38694/v477/3/6/timdOsC5R7yf9FTPdtRqkw.mp4";
        }

        videoView.setVideoPath(videoPath);
        //package must be io.vov.vitamio.widget.MedioCntroller
        mediaController = new MediaController(this);
        mediaController.show(5000);
        videoView.setMediaController(mediaController);
        videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
        videoView.requestFocus();



    }


    private void initEvent(){

        weixin.setOnClickListener(this);
        qzone.setOnClickListener(this);
        qq.setOnClickListener(this);
        sina.setOnClickListener(this);




    }


    private void loadData(){
    }

    @Override
    public void onClick(View v){



        switch(v.getId()){
            case R.id.weichat_videoplayActivity:
                Intent intent01 = new Intent(this, LoginRegisterActivity.class);
                startActivity(intent01);
            break;

            case R.id.qzone_videoplayActivity:
                Intent intent02 = new Intent(this, LoginRegisterActivity.class);
                startActivity(intent02);
                break;

            case R.id.qq_videoplayActivity:
                Intent intent03 = new Intent(this, LoginRegisterActivity.class);
                startActivity(intent03);
                break;

            case R.id.sina_videoplayActivity:
                Intent intent04 = new Intent(this, LoginRegisterActivity.class);
                startActivity(intent04);
                break;
        }


    }
}
