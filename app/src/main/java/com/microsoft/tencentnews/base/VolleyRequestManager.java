package com.microsoft.tencentnews.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 16-7-7.
 */
public class VolleyRequestManager{


    public static VolleyRequestManager volleyRequestManager;
    private  RequestQueue requestQueue;
    private  ImageLoader imageLoader;





    private VolleyRequestManager(Context context){
        requestQueue = Volley.newRequestQueue(context);
        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache(){

            private LruCache<String, Bitmap> lruCache = new LruCache<>(50);

            @Override
            public Bitmap getBitmap(String s){
                return lruCache.get(s);
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap){
                lruCache.put(s, bitmap);
            }
        });
    }





    public static VolleyRequestManager createInstance(Context context){
        if(context != null){
            if(volleyRequestManager == null){
                volleyRequestManager = new VolleyRequestManager(context);
            }else{
                throw new IllegalArgumentException("Context must be set ");
            }
        }
        return volleyRequestManager;
    }



    public  RequestQueue getRequestQueue(){


        return requestQueue;
    }

    public  ImageLoader getImageLoader(){

        return imageLoader;
    }




}
