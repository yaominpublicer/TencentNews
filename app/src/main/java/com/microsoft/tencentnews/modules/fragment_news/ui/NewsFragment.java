package com.microsoft.tencentnews.modules.fragment_news.ui;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.common.adapter.News_FragmentPagerAdapter;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_army.ui.News_armyFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_culture.ui.News_cultureFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_fashion.ui.News_fashionFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_films.ui.News_filmsFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_society.ui.News_societyFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_technology.ui.News_technologyFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_video.ui.News_videoFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_car.ui.News_carFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_digital.ui.News_digitalFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_entertaiment.ui.News_entertaimentFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_finanice.ui.News_finaniceFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_img.ui.News_imgFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_nba.ui.News_nbaFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_news.ui.News_newsFragment;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_sport.ui.News_sportFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment{

    private String TAG="NewsFragment";

    private TabLayout itemTabLayout;
    private ViewPager viewPage_news;

    private List<BaseFragment> fragmentList = new ArrayList<>();
    private List<String> itemTabList=new ArrayList<>();
    private ImageView pluseimage_news;

    @Override
    protected int setViewID(){
        //return R.layout.fragment_news_video ;
       return R.layout.fragment_news;
    }

    @Override
    protected void findViews(View myView){
        itemTabLayout = (TabLayout) myView.findViewById(R.id.tabLayout_news);
        viewPage_news = (ViewPager) myView.findViewById(R.id.viewPager_news);
        pluseimage_news = (ImageView) myView.findViewById(R.id.imgPlus_news);
    }

    @Override
    protected void initData(){


        //1:list
        News_newsFragment news_newsFragment = new News_newsFragment();
        News_videoFragment news_videoFragment = new News_videoFragment();
        News_entertaimentFragment news_entertaimentFragment = new News_entertaimentFragment();
        News_imgFragment news_imgFragment = new News_imgFragment();
        News_sportFragment news_sportFragment = new News_sportFragment();
        News_nbaFragment news_nbaFragment = new News_nbaFragment();
        News_finaniceFragment news_finaniceFragment = new News_finaniceFragment();
        News_carFragment news_carFragment = new News_carFragment();
        News_technologyFragment news_technologyFragment = new News_technologyFragment();
        News_societyFragment news_societyFragment = new News_societyFragment();
        News_armyFragment news_armyFragment = new News_armyFragment();
        News_fashionFragment news_fashionFragment = new News_fashionFragment();
        News_cultureFragment news_cultureFragment = new News_cultureFragment();
        News_digitalFragment news_digitalFragment = new News_digitalFragment();
        News_filmsFragment news_filmsFragment = new News_filmsFragment();






        fragmentList.add(news_newsFragment);
        fragmentList.add(news_videoFragment);
        fragmentList.add(news_entertaimentFragment);
        fragmentList.add(news_imgFragment);
        fragmentList.add(news_sportFragment);
        fragmentList.add(news_nbaFragment);
        fragmentList.add(news_finaniceFragment);
        fragmentList.add(news_carFragment);
        fragmentList.add(news_technologyFragment);
        fragmentList.add(news_societyFragment);
        fragmentList.add(news_armyFragment);
        fragmentList.add(news_fashionFragment);
        fragmentList.add(news_cultureFragment);
        fragmentList.add(news_digitalFragment);
        fragmentList.add(news_filmsFragment);



        itemTabList.add("要闻");
        itemTabList.add("视频");
        itemTabList.add("娱乐");
        itemTabList.add("图片");
        itemTabList.add("体育");
        itemTabList.add("NBA");
        itemTabList.add("财经");
        itemTabList.add("汽车");
        itemTabList.add("科技");
        itemTabList.add("社会");
        itemTabList.add("军事");
        itemTabList.add("时尚");
        itemTabList.add("文化");
        itemTabList.add("数码");
        itemTabList.add("电影");





        //2:adapter
        android.support.v4.app.FragmentManager  fragmentManager = getActivity().getSupportFragmentManager();

        News_FragmentPagerAdapter news_fragmentPagerAdapter = new News_FragmentPagerAdapter(fragmentManager,fragmentList,itemTabList);

        viewPage_news.setAdapter(news_fragmentPagerAdapter);
        itemTabLayout.setupWithViewPager(viewPage_news);

        viewPage_news.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getContext(),"click",Toast.LENGTH_SHORT);
            }
        });

        itemTabLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getContext(),"click",Toast.LENGTH_SHORT);
            }
        });







    }


    @Override
    protected void initEvent(){




    }

    @Override
    protected void loadData(){









    }

    @Override
    protected void obtainContext(Context context){
    }
}
