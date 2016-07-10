package com.microsoft.tencentnews.modules.fragment_live.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.common.adapter.LiveRecycleAdapter;
import com.microsoft.tencentnews.common.adapter.RecycelViewDecorator;
import com.microsoft.tencentnews.common.constante.Constante;
import com.microsoft.tencentnews.common.net.HttpUtils;
import com.microsoft.tencentnews.common.utils.UtilsAssets;
import com.microsoft.tencentnews.modules.fragment_live.bean.NewsBeanLive;
import com.microsoft.tencentnews.modules.fragment_live.bean.SubNewsBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends BaseFragment{

    private Context mycontext;
    private RecyclerView recyclerView;
    private List<SubNewsBean> subNewsBeanList = new ArrayList<>();
    private static int pageNum = 0;
    private static int listNum = 10;
    private LiveRecycleAdapter adapter;
    private NewsBeanLive gsonClazz = new NewsBeanLive();

    private Handler myHandler;
    private View footview;

    @Override
    protected int setViewID(){
        return R.layout.fragment_live;
    }

    @Override
    protected void findViews(View mView){
        recyclerView = (RecyclerView) mView.findViewById(R.id.recycleView_live);
        footview = (View) mView.findViewById(R.id.progressbar_footview_live);
    }

    @Override
    protected void initData(){
    }

    @Override
    protected void initEvent(){
        adapter = new LiveRecycleAdapter(mycontext, subNewsBeanList);
        final LinearLayoutManager manager = new LinearLayoutManager(mycontext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        RecycelViewDecorator decor = new RecycelViewDecorator(mycontext, 0);
        recyclerView.addItemDecoration(decor);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState){
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                super.onScrolled(recyclerView, dx, dy);
                int passNum = manager.findFirstCompletelyVisibleItemPosition();
                int currentNum = manager.getChildCount();
                int allNum = manager.getItemCount();
                if(passNum + currentNum >= allNum){
                    loadDataStep(++pageNum, listNum);
                    footview.setVisibility(View.VISIBLE);
                    SystemClock.sleep(3000);
                    footview.setVisibility(View.INVISIBLE);
                }
            }
        });


        adapter.setOnRecycleViewItemClickListener03(new LiveRecycleAdapter.OnRecycleViewItemClickListener03(){
            @Override
            public void clickItem(View v, String webUrl){




            }
        });

        myHandler = new Handler(){

            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                switch(msg.what){
                    case Constante.HANDLER_SUCCESS:
                        List<SubNewsBean> list = ((NewsBeanLive) msg.obj).getV9LG4B3A0();
                        subNewsBeanList.addAll(list);
                        adapter.notifyDataSetChanged();

                        break;
                    case Constante.HANDLER_ERROR:
                        Log.e("livefragment ", "handleMessage: ----error ----");
                        break;
                }
            }
        };
    }

    @Override
    protected void loadData(){
        loadDataStep(pageNum, listNum);
    }

    @Override
    protected void obtainContext(Context context){
        mycontext = context;
    }
    //

    public void loadDataStep(final int pageCount, final int listCount){
        new Thread(new Runnable(){
            @Override
            public void run(){
                HashMap<String, List<String>> liveinterfaceMap = UtilsAssets.getInterfaceUrlMap(mycontext, "liveinterface");
                List<String> liveinterfaceList = liveinterfaceMap.get("live_interface.txt");
                String liveUrl = liveinterfaceList.get(0);

                //http://c.3g.163.com/nc/video/list/V9LG4B3A0/n/10-10.html
                String baseUrl = liveUrl.substring(0, liveUrl.lastIndexOf("/") + 1);
                String url = baseUrl + pageCount + "-" + listCount + ".html";

                NewsBeanLive newsBeanLive = null;

                try{
                    String jsonStr = HttpUtils.getJsonString(mycontext, url);
                    if(jsonStr != null || jsonStr.length() > 0){
                        newsBeanLive = HttpUtils.parseJson(gsonClazz, jsonStr);
                        if(newsBeanLive == null){
                        }
                    }
                }catch(Exception e){
                }



                Message message = myHandler.obtainMessage();
                if(newsBeanLive != null){
                    message.what = Constante.HANDLER_SUCCESS;
                    message.obj = newsBeanLive;

                    myHandler.sendMessage(message);
                }else {
                    myHandler.sendEmptyMessage(Constante.HANDLER_ERROR);
                }

            }
        }).start();
    }
}
