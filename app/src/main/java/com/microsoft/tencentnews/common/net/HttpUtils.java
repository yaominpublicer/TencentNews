package com.microsoft.tencentnews.common.net;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by Administrator on 2016/7/7.
 */
public class HttpUtils {


    private static String jsonString;

    public static   String    downLoadJson(final Context context, String urlString) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest request = new JsonObjectRequest(urlString, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                jsonString = jsonObject.toString();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(context, "net work error ", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
        return jsonString;
    }


    public static void paseJson(String jsonstr){






    }





}
