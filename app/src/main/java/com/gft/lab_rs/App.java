package com.gft.lab_rs;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;

import com.gft.lab_rs.network.AppManager;
import com.gft.lab_rs.utils.FileUtils;
import com.gft.lab_rs.utils.LogUtils;


/**
 * Created by ZHT on 2017/4/17.
 * 自定义Application
 */

public class App extends Application {
    private static App instance;
    private static App mContext;

    private static Handler mMainThreadHandler;

    //static 代码段可以防止内存泄露
/*
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }
*/



    public Vibrator mVibrator;

//    public static double x=0;
//    public static double y=0;




    @Override
    public void onCreate() {
        super.onCreate();

       // CrashReport.initCrashReport(getApplicationContext(), "861604062a", false);//腾讯bugly统计

        /***
         * 初始化定位sdk，建议在Application中创建
         */

        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);

//        locationService.registerListener(mListener);

        instance = this;
        mContext = this;
        mMainThreadHandler = new Handler();
        ActivitStats();
        //设置是否打印日志
        LogUtils.setIsLog(BuildConfig.LOG_DEBUG);

        //在6.0(M)版本下直接创建应用对应的文件夹
        //在6.0(M)版本以上的需要先进行权限申请
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            FileUtils.init(this);
        }
    }

    public static App getInstance() {
        return instance;
    }

    public static App getApplication() {
        return mContext;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }


//    BDAbstractLocationListener mListener = new BDAbstractLocationListener() {
//        @Override
//        public void onReceiveLocation(BDLocation bdLocation) {
//            bdLocation.getLatitude();
//            bdLocation.getLongitude();
//            x =  bdLocation.getLatitude();
//            y =   bdLocation.getLongitude();
//            Log.e("app", x+""+bdLocation.getCity()+"");
//        }
//    };


    @Override
    public void onTerminate() {
        // 程序终止的时候执行
//        locationService.unregisterListener(mListener); //注销掉监听
//        locationService.stop(); //停止定位服务
        super.onTerminate();

    }

    //监听当前Activit状态
    private void ActivitStats() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                AppManager.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
