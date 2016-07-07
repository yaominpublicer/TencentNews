package com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_news.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.common.adapter.News_newsAdapter;
import com.microsoft.tencentnews.common.adapter.RecycelViewDecorator;
import com.microsoft.tencentnews.common.constante.Constante;
import com.microsoft.tencentnews.common.net.HttpUtils;
import com.microsoft.tencentnews.common.utils.UtilsAssets;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_news.bean.NewsBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class News_newsFragment extends BaseFragment{

    private RecyclerView recyclerView;
    private HashMap<String, List<String>> interfaceUrlMap = new HashMap<>();
    private List<String> army_interfaceList;
    private List<String> car_interfaceList;
    private List<String> culture_interfaceList;
    private List<String> digital_interfaceList;
    private List<String> entertaimentList;
    private List<String> fashionList;
    private List<String> filmsList;
    private List<String> financeList;
    private List<String> imageList;
    private List<String> nbaList;
    private List<String> newsList;
    private List<String> societyList;
    private List<String> sportList;
    private List<String> technologyList;
    private List<String> videoList;

    private final List<NewsBean.NewsContent> nclist = new ArrayList<>();

    private Context mycontext;
    private static int page;
    private List<NewsBean.NewsContent> list=new ArrayList<>();

    private Handler myHandler ;

    @Override
    protected int setViewID(){
        return R.layout.fragment_news_news;
    }

    @Override
    protected void findViews(View myView){
        recyclerView = (RecyclerView) myView.findViewById(R.id.recycelView_news_news);
    }

    @Override
    protected void initData(){
        //1:initData
        AssetManager assetManager = getResources().getAssets();
        try{
            String[] fileList = assetManager.list("newsinterface");
            for(int i = 0; i < fileList.length; i++){
                List<String> interfaceList = UtilsAssets.getInterfaceFromAssets(assetManager, "newsinterface/" + fileList[i]);
                //interfaceMap 存news模块不同页面的接口；k=文件名，v=接口字符串；
                if(interfaceList != null){
                    interfaceUrlMap.put(fileList[i], interfaceList);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        //1:获取news fragment 下各个页面的接口数据list
        // :因为接口是抓取的 无法获取接口 根URL只能抓取各个页面的 单一页数据，所以分别抓取放在assets中来读取
        army_interfaceList = interfaceUrlMap.get("army_interface.txt");
        car_interfaceList = interfaceUrlMap.get("car_interface.txt");
        culture_interfaceList = interfaceUrlMap.get("culture_interface.txt");
        digital_interfaceList = interfaceUrlMap.get("digital_interface.txt");
        entertaimentList = interfaceUrlMap.get("entertaiment_interface.txt");
        fashionList = interfaceUrlMap.get("fashion_interface.txt");
        filmsList = interfaceUrlMap.get("films_interface.txt");
        financeList = interfaceUrlMap.get("finance_interface.txt");
        imageList = interfaceUrlMap.get("image_interface.txt");
        nbaList = interfaceUrlMap.get("nba_interface.txt");
        newsList = interfaceUrlMap.get("news_interface.txt");
        societyList = interfaceUrlMap.get("society_interface.txt");
        sportList = interfaceUrlMap.get("sport_interface.txt");
        technologyList = interfaceUrlMap.get("technology_interface.txt");
        videoList = interfaceUrlMap.get("video_interface.txt");

        //1:根据接口数据下载

        page = 0;
        recycleViewStepLoad(page);

        //2:adapter

         final News_newsAdapter adapter = new News_newsAdapter(mycontext, nclist);


        //3:setadapter
        LinearLayoutManager manager = new LinearLayoutManager(mycontext, LinearLayoutManager.VERTICAL, false);
        RecycelViewDecorator decorator = new RecycelViewDecorator(mycontext, 0);
        recyclerView.addItemDecoration(decorator);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        //setAdapter





        myHandler= new Handler(){

            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                switch(msg.what){
                    case Constante.HANDLER_SUCCESS:
                        List<NewsBean.NewsContent> newsContentList = ((NewsBean) msg.obj).getNewslist();

                        Log.e("handler", "handleMessage: "+newsContentList.size());
                        nclist.addAll(newsContentList);

                        adapter.notifyDataSetChanged();

                        break;
                    case Constante.HANDLER_ERROR:
                        break;
                }
            }
        };







    }

    @Override
    protected void initEvent(){





    }

    @Override
    protected void loadData(){
        // 先解析第一页

    }

    @Override
    protected void obtainContext(Context context){
        mycontext = context;
    }


    public void recycleViewStepLoad(int pagenum){

        final NewsBean nb = new NewsBean();
        final String url = newsList.get(pagenum);

        new Thread(new Runnable(){
            @Override
            public void run(){

                NewsBean newsBean ;
                String jsonStr = HttpUtils.downLoadJson(mycontext, url);
                newsBean = HttpUtils.parseJson(nb, jsonStr);
                if(newsBean != null){
                    Message message = myHandler.obtainMessage();
                    message.what = Constante.HANDLER_SUCCESS;
                    message.obj = newsBean;
                    int num=newsBean.getNewslist().size();
                    Log.e("thread","rum: --------"+num);
                    myHandler.sendMessage(message);
                }
            }
        }).start();
    }
}
