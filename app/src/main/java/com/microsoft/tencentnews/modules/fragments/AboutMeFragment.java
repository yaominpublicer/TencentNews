package com.microsoft.tencentnews.modules.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.microsoft.tencentnews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutMeFragment extends Fragment{

    public AboutMeFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aboutme, container, false);
    }
}