package com.microsoft.tencentnews.common.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.microsoft.tencentnews.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/7.
 */
public class HttpUtils{

    private static String jsonStr;



    public static String downLoadJson(final Context context, String urlString){
        RequestQueue queue = Volley.newRequestQueue(context);
        try{
            StringRequest request = new StringRequest(urlString,
                    new Response.Listener<String>(){

                @Override
                public void onResponse(String s){
                    jsonStr = s;
                    Log.e("volley", "onResponse: ok");
                }
            }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError volleyError){
                    Toast.makeText(context, "net work error ", Toast.LENGTH_SHORT).show();
                    Log.e("volley", "onResponse: error");
                }
            });
            queue.add(request);
        }catch(Exception e){
            Log.e("volley","--------volley----downLoadJson: ----error---- ");
            e.printStackTrace();
        }
        return jsonStr;
    }




    public static <T> T parseJson(T clazz, String jsonStr){
        //htttp://  length = 7
        try{
            if(jsonStr != null && jsonStr.length()>7){
                Gson gson = new Gson();
                T t = (T) gson.fromJson(jsonStr, clazz.getClass());
                return t;
            }else {

                throw  new IllegalArgumentException(" ----gson parse error----");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getJsonString(Context context, String url){
        //1:判断网络
        HttpURLConnection conn = null;
        InputStream is;
        try{
            URL myurl = new URL(url);
            conn = (HttpURLConnection) myurl.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            conn.setReadTimeout(5 * 1000);
            conn.connect();
            if(conn.getResponseCode() == 200){
                is = conn.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));
                StringBuffer stringBuffer = new StringBuffer();
                String line;
                while((line = bf.readLine()) != null){
                    stringBuffer.append(line);
                }
                String resultStr = stringBuffer.toString();
                return resultStr;
            }
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param context   从basefragment 继承下来的上下文对象
     * @param imgWidth  二次采样图片宽度在viewholer获取（view.getLayoutParams.width）
     * @param imgHeight 二次采样图片高度viewholer获取（view.getLayoutParams.height）
     * @param imgURL    图片下载地址
     * @param image     将要把网络图片加载的目标图片
     */
    public static void volleyLoadImage(final Context context, int imgWidth, int imgHeight, String imgURL, final ImageView image){

       if(TextUtils.isEmpty(imgURL) || imgURL.length() <1){

           image.setImageDrawable(context.getResources().getDrawable(R.drawable.icon));
           return;
       }
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(imgURL, new Response.Listener<Bitmap>(){
            @Override
            public void onResponse(Bitmap bitmap){
                if(bitmap != null){
                    image.setImageBitmap(bitmap);
                    Log.e("onErrorResponse: 2 ", "image down ok ");
                }
            }
        }, imgWidth, imgHeight, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.RGB_565, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError volleyError){

                image.setImageDrawable(context.getResources().getDrawable(R.drawable.icon));

                Log.e("onErrorResponse: 3", "image down error ");
                //设置默认图片
                // Toast.makeText(context, "image network error", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(imageRequest);
    }
}
