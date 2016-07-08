package com.microsoft.tencentnews.common.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 16-7-5.
 */
public class UtilsAssets{




    //1:此类功能 读取assets目录下的网络接口文件
    public static List<String> getInterfaceFromAssets(AssetManager manager, String fileName){
        InputStream inputStream = null;
        BufferedReader bfReader = null;
        StringBuffer stBuffer;
        List<String> interfaceList = new ArrayList<>();
        try{
            inputStream = manager.open(fileName);
            bfReader = new BufferedReader(new InputStreamReader(inputStream));
            stBuffer = new StringBuffer();
            String line;
            while((line = bfReader.readLine()) != null){
                stBuffer.append(line);
            }
            String allString = stBuffer.toString();
            if(allString == null){
                throw new IllegalArgumentException(" --------null--------- ");
            }
            String[] interfaceArray = allString.split("http://");
            for(int i = 0; i < interfaceArray.length; i++){
                String s = interfaceArray[i];
                if(s != null && s.length() >= 1){
                    String temp = "http://" + s.trim();
                    interfaceList.add(temp);
                    // Log.d("getInterfaceFromAssets: ",temp);
                }
            }
            return interfaceList;
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(bfReader != null){
                try{
                    bfReader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try{
                    inputStream.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * \
     * @param context
     * @param assetPath  文件夹路径  （如：“newsinterface”）
     * @return 文件夹下的文件map k:file_name  v:list<string>
     */

    public static HashMap<String,List<String>> getInterfaceUrlMap(Context context,String assetPath){


        AssetManager assetManager = context.getResources().getAssets();
        HashMap<String,List<String>> interfaceUrlMap = new HashMap<>();
        try{
            String[] fileList = assetManager.list(assetPath);
            for(int i = 0; i < fileList.length; i++){
                List<String> interfaceList = UtilsAssets.getInterfaceFromAssets(assetManager, assetPath+"/" + fileList[i]);
                //interfaceMap 存news模块不同页面的接口；k=文件名，v=接口字符串；
                if(interfaceList != null){
                    interfaceUrlMap.put(fileList[i], interfaceList);
                }
            }

            if(interfaceUrlMap.size() <= 0){
                return null;
            }else {

               return interfaceUrlMap;

            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }






}
