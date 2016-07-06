package com.microsoft.tencentnews.modules.mainactivity.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseActivity;
import com.microsoft.tencentnews.modules.fragment_aboutme.ui.AboutMeFragment;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.modules.fragment_live.ui.LiveFragment;
import com.microsoft.tencentnews.modules.fragment_news.ui.NewsFragment;
import com.microsoft.tencentnews.modules.fragment_recommend.ui.RecomendFragment;

/**
 * Created by Administrator on 16-7-5.
 */
public class MainActivity extends BaseActivity{

    private FrameLayout fragmentContainer;
    private RadioGroup radioGroup;
    private RadioButton recommendButton;
    private RadioButton liveButton;
    private RadioButton newsButton;
    private RadioButton aboutmeButton;

    private Fragment tempFragment;
    private BaseFragment newsFragment;
    private BaseFragment recomendFragment;
    private BaseFragment liveFragment;
    private BaseFragment aboutMeFragment;
    private int checkedID;






    @Override
    protected int setViewID(){
        return R.layout.activity_main;
    }


    //2: find views
    @Override
    protected void findViews(){


        //1:find view
        fragmentContainer = (FrameLayout) findViewById(R.id.fragmentContainer);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        recommendButton = (RadioButton) findViewById(R.id.recommend);
        liveButton = (RadioButton) findViewById(R.id.live);
        newsButton = (RadioButton) findViewById(R.id.news);
        aboutmeButton = (RadioButton) findViewById(R.id.aboutMe);
    }

    //3:初始化数据 new object
    @Override
    protected void initData(){

        //2:new  fragment (4)
        newsFragment = new NewsFragment();
        recomendFragment = new RecomendFragment();
        liveFragment = new LiveFragment();
        aboutMeFragment = new AboutMeFragment();

        //3:创建fragmentmanager ps: v4  support
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //4:begin transaction to add fragment (4)
        fragmentTransaction.add(R.id.fragmentContainer, newsFragment,"news");
        fragmentTransaction.add(R.id.fragmentContainer, recomendFragment,"recommend");
        fragmentTransaction.add(R.id.fragmentContainer, liveFragment,"live");
        fragmentTransaction.add(R.id.fragmentContainer, aboutMeFragment,"aboutme");

        //5: hide all fragment
        // then according to the checked id to show fragment
        fragmentTransaction.hide(newsFragment);
        fragmentTransaction.hide(recomendFragment);
        fragmentTransaction.hide(liveFragment);
        fragmentTransaction.hide(aboutMeFragment);

        //6: new a temp fragment to save the last show fragment

        tempFragment = new Fragment();
        checkedID = radioGroup.getCheckedRadioButtonId();


        if(R.id.news== checkedID){
            //:显示
            fragmentTransaction.show(newsFragment);
            tempFragment = newsFragment;
        }else if(R.id.recommend == checkedID){
            fragmentTransaction.show(recomendFragment);
            tempFragment = recomendFragment;

        }else if(R.id.live == checkedID){
            fragmentTransaction.show(liveFragment);
            tempFragment = liveFragment;
        }else {
            fragmentTransaction.show(aboutMeFragment);
            tempFragment = aboutMeFragment;

        }


        //7:commit transaction
        fragmentTransaction.commit();
    }



    //4:事件监听
    @Override
    protected void initEvent(){

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){

                showFragment(checkedId);


            }
        });
    }

    //5:获取数据
    @Override
    protected void loadData(){
    }



    private void showFragment(int checkedID){

        //1:重新开启事务，不用上面的
        FragmentManager fragment=getSupportFragmentManager();
        FragmentTransaction ft=fragment.beginTransaction();


        if(R.id.news==checkedID){
        //:1:把原先的fragment 隐藏，2：显示选中 3：把选中的fragment 保存到tempFragment
            ft.hide(tempFragment);
            ft.show(newsFragment);
            tempFragment =newsFragment;
        }else if(R.id.recommend == checkedID){
            ft.hide(tempFragment);
            ft.show(recomendFragment);
            tempFragment =recomendFragment;

        }else if(R.id.live == checkedID){
            ft.hide(tempFragment);
            ft.show(liveFragment);
            tempFragment =liveFragment;
        }else {
            ft.hide(tempFragment);
            ft.show(aboutMeFragment);
            tempFragment =aboutMeFragment;


        }

        ft.commit();

    }

}
