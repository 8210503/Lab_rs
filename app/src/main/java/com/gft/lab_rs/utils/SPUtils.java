package com.gft.lab_rs.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.gft.lab_rs.App;


/**
 * SharedPreferences工具类
 */
/*https://blog.csdn.net/u010198148/article/details/51706483
*commit和apply是不同的,注意一下
* */
public class SPUtils {

    private SPUtils() {}

    private static SharedPreferences getSharedPreferences() {
        return App.getApplication()
                .getSharedPreferences(App.getApplication().getPackageName(), Context.MODE_PRIVATE);
    }


    /**
     * 保存boolean类型配置信息
     * @param key
     * @param value
     */
    public static void saveBoolean(String key, boolean value) {
        getSharedPreferences().edit()
                .putBoolean(key, value)
                .commit();
    }

    /**
     * 获取boolean类型配置信息
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean(String key, boolean defValue) {
        return getSharedPreferences().getBoolean(key, defValue);
    }

    /**
     * 保存int类型配置信息
     * @param key
     * @param value
     */
    public static void saveInt(String key, int value) {
        getSharedPreferences().edit()
                .putInt(key, value)
                .commit();
    }

    /**
     * 获取int类型配置信息
     * @param key
     * @param defValue
     * @return
     */
    public static int getInt(String key, int defValue) {
        return getSharedPreferences().getInt(key, defValue);
    }

    /**
     * 保存long类型配置信息
     * @param key
     * @param value
     */
    public static void saveLong(String key, long value) {
        getSharedPreferences().edit()
                .putLong(key, value)
                .commit();
    }

    /**
     * 获取long类型配置信息
     * @param key
     * @param defValue
     * @return
     */
    public static long getLong(String key, Long defValue) {
        return getSharedPreferences().getLong(key, defValue);
    }

    /**
     * 保存String类型配置信息
     * @param key
     * @param value
     */
    public static void saveString(String key, String value) {
        getSharedPreferences().edit()
                .putString(key, value)
                .commit();
    }

    /**
     * 获取String类型配置信息
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(String key, String defValue) {
        return getSharedPreferences().getString(key, defValue);
    }

    public static void removeKey(String key) {
        getSharedPreferences().edit().remove(key)
                .commit();
    }

    public static void removeAll() {
        getSharedPreferences().edit().clear().commit();
    }
}
