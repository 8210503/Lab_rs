package com.gft.lab_rs.utils;

/**
 * Created by Administrator on 2017/12/26.
 * 防止点击事件的重复提交
 */

public class SingleClick {

    private static final int DEFAULT_TIME = 2000;
    private static long lastTime;

    public static boolean isSingle(){
        boolean isSingle ;
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastTime <= DEFAULT_TIME){
            isSingle = true;
        }else{
            isSingle = false;
        }
        lastTime = currentTime;

        return isSingle;
    }
}
