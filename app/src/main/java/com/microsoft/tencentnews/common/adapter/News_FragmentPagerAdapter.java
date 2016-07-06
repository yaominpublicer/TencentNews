package com.microsoft.tencentnews.common.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.microsoft.tencentnews.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 16-7-6.
 */
public class News_FragmentPagerAdapter extends FragmentPagerAdapter{

    private List<BaseFragment> fragmentList;
    private List<String> itemTabList;

    public News_FragmentPagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList, List<String> itemTabList){
        super(fm);
        this.fragmentList=fragmentList;
        this.itemTabList = itemTabList;

    }

    @Override
    public Fragment getItem(int position){
        return fragmentList.get(position);
    }

    @Override
    public int getCount(){
        return fragmentList.size();
    }


    @Override
    public CharSequence getPageTitle(int position){


        return itemTabList.get(position);
    }
}
