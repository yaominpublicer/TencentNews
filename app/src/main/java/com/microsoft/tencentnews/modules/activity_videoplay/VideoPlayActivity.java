package com.microsoft.tencentnews.modules.activity_videoplay;

import android.content.res.Configuration;
import android.widget.MediaController;
import android.widget.VideoView;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseActivity;

/**
 * Created by Administrator on 2016/7/10.
 */
public class VideoPlayActivity extends BaseActivity {
    @Override
    protected int setViewID() {

        return R.layout.activity_videoplay;

    }

    @Override
    protected void findViews() {


        VideoView videoView = (VideoView) findViewById(R.id.videoView_VideoActivity);
        MediaController controller = new MediaController(this);
        videoView.setMediaController(controller);





    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initEvent() {


        //横屏
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){

            getResources().getConfiguration().orientation=Configuration.ORIENTATION_PORTRAIT;



        }

        //竖屏
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){


        }
    }

    @Override
    protected void loadData() {

    }
}
