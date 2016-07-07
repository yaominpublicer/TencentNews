package com.microsoft.tencentnews.common.net;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

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
public class HttpUtils {

    private static String jsonStr;

    public static String   downLoadJson(final Context context, String urlString) {


        RequestQueue queue = Volley.newRequestQueue(context);


        StringRequest request = new StringRequest(urlString, new Response.Listener<String>(){

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
        return jsonStr;
    }



    public static  <T>T parseJson(T clazz,String jsonStr){
        Gson gson = new Gson();
        T t = (T) gson.fromJson(jsonStr, clazz.getClass());
        return t;
    }




    public static String getJsonString(Context context,String url){

        //1:判断网络
        HttpURLConnection conn=null;
        InputStream is;
        try{
            URL myurl=new URL(url);

            conn = (HttpURLConnection) myurl.openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5*1000);
            conn.setReadTimeout(5*1000);
            conn.connect();

            if(conn.getResponseCode() == 200){

                is = conn.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));

                StringBuffer stringBuffer = new StringBuffer();


                String line ;

                while((line = bf.readLine()) != null){
                    stringBuffer.append(line);
                }

                String resultStr=stringBuffer.toString();
                return resultStr;


            }



        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }







}
