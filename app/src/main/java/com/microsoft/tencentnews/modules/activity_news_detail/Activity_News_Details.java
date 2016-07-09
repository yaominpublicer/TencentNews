package com.microsoft.tencentnews.modules.activity_news_detail;

import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseActivity;

/**
 * Created by Administrator on 16-7-9.
 */
public class Activity_News_Details extends BaseActivity{

    private WebView webView;
    private String weburl;

    @Override
    protected int setViewID(){
        return R.layout.activity_news_details;
    }

    @Override
    protected void findViews(){
        webView = (WebView) findViewById(R.id.webview);
    }

    @Override
    protected void initData(){
        Intent receiveIntent = getIntent();
        weburl = receiveIntent.getStringExtra("url");
    }

    @Override
    protected void initEvent(){

        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.loadUrl(weburl);

    }

    @Override
    protected void loadData(){
    }
}
