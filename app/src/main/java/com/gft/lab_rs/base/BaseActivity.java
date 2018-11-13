package com.gft.lab_rs.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gft.lab_rs.R;
import com.gft.lab_rs.network.ApiService;
import com.gft.lab_rs.network.HttpsRequest;
import com.gft.lab_rs.utils.ActivityUtils;
import com.gft.lab_rs.utils.PermissionListener;
import com.gft.lab_rs.utils.ProgressDialogUtils;
import com.gft.lab_rs.widget.NetworkStateView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;


/**
 * Created by ZHT on 2017/4/17.
 * Activity基类
 */

public abstract class BaseActivity extends AppCompatActivity implements NetworkStateView.OnRefreshListener {

    private Unbinder unbinder;

    private ProgressDialogUtils progressDialog;

    private NetworkStateView networkStateView;

    public ApiService apiService;

    /**
     * 网络请求时，发生退出，用于取消网络请求
     */
    public Subscription mSubscription;

    private static PermissionListener mPermissionListener;
    private static final int CODE_REQUEST_PERMISSION = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        ActivityUtils.addActivity(this);
        apiService = HttpsRequest.provideClientApi();

        initDialog();
        afterCreate(savedInstanceState);

//        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.base_rootlayout);
//        RelativeLayout titleLayout = byView(R.id.title_rootlayout);
//        ImageView backIv = byView(R.id.title_rootlayout_backIv);
//        TextView backTv = byView(R.id.title_rootlayout_backTv);
//        TextView titleTv = byView(R.id.title_rootlayout_middleTv);
//        ImageView rightIv = byView(R.id.title_rootlayout_rightIv);
//        TextView rightTv = byView(R.id.title_rootlayout_rightTv);

//        backIv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//        backTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
//        backIv.setImageResource(R.mipmap.xzgl_03);
//        initTitle(titleLayout, backIv, backTv, titleTv, rightIv, rightTv);

    }

    protected abstract void initTitle(RelativeLayout titleLayout, ImageView backIv, TextView backTv, TextView titleTv, ImageView rightIv, TextView rightTv);


    @SuppressLint("InflateParams")
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View view = getLayoutInflater().inflate(R.layout.activity_base, null);
        //设置填充activity_base布局
        super.setContentView(view);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            view.setFitsSystemWindows(true);
        }
        //加载子类Activity的布局
        initDefaultView(layoutResID);

    }
    /**
     * 初始化默认布局的View
     * @param layoutResId 子View的布局id
     */
    private void initDefaultView(int layoutResId) {
        networkStateView = (NetworkStateView) findViewById(R.id.nsv_state_view);
        FrameLayout container = (FrameLayout) findViewById(R.id.fl_activity_child_container);
        View childView = LayoutInflater.from(this).inflate(layoutResId, null);
        container.addView(childView, 0);
    }


    //    findViewById精简 (组件)
    protected <T extends View> T byView(int resId) {
        return (T) findViewById(resId);
    }


    protected abstract int getLayoutId();

    protected abstract void afterCreate(Bundle savedInstanceState);

    private void initDialog() {
        progressDialog = new ProgressDialogUtils(this, R.style.dialog_transparent_style);
    }

    /**
     * 显示加载中的布局
     */
    public void showLoadingView() {
        networkStateView.showLoading();
    }

    /**
     * 显示加载完成后的布局(即子类Activity的布局)
     */
    public void showContentView() {
        networkStateView.showSuccess();
    }

    /**
     * 显示没有网络的布局
     */
    public void showNoNetworkView() {
        networkStateView.showNoNetwork();
        networkStateView.setOnRefreshListener(this);
    }

    /**
     * 显示没有数据的布局
     */
    public void showEmptyView() {
        networkStateView.showEmpty();
        networkStateView.setOnRefreshListener(this);
    }

    /**
     * 显示数据错误，网络错误等布局
     */
    public void showErrorView() {
        networkStateView.showError();
        networkStateView.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        onNetworkViewRefresh();
    }

    /**
     * 重新请求网络
     */
    public void onNetworkViewRefresh() {
    }

    /**
     * 显示加载的ProgressDialog
     */
    public void showProgressDialog() {
        progressDialog.showProgressDialog();
    }

    /**
     * 显示有加载文字ProgressDialog，文字显示在ProgressDialog的下面
     *
     * @param text 需要显示的文字
     */
    public void showProgressDialogWithText(String text) {
        progressDialog.showProgressDialogWithText(text);
    }

    /**
     * 显示加载成功的ProgressDialog，文字显示在ProgressDialog的下面
     *
     * @param message 加载成功需要显示的文字
     * @param time    需要显示的时间长度(以毫秒为单位)
     */
    public void showProgressSuccess(String message, long time) {
        progressDialog.showProgressSuccess(message, time);
    }

    /**
     * 显示加载成功的ProgressDialog，文字显示在ProgressDialog的下面
     * ProgressDialog默认消失时间为1秒(1000毫秒)
     *
     * @param message 加载成功需要显示的文字
     *
     */
    public void showProgressSuccess(String message) {
        progressDialog.showProgressSuccess(message);
    }

    /**
     * 显示加载失败的ProgressDialog，文字显示在ProgressDialog的下面
     *
     * @param message 加载失败需要显示的文字
     * @param time    需要显示的时间长度(以毫秒为单位)
     */
    public void showProgressFail(String message, long time) {
        progressDialog.showProgressFail(message, time);
    }

    /**
     * 显示加载失败的ProgressDialog，文字显示在ProgressDialog的下面
     * ProgressDialog默认消失时间为1秒(1000毫秒)
     *
     * @param message 加载成功需要显示的文字
     *
     */
    public void showProgressFail(String message) {
        progressDialog.showProgressFail(message);
    }

    /**
     * 隐藏加载的ProgressDialog
     */
    public void dismissProgressDialog() {
        progressDialog.dismissProgressDialog();
    }

    /**
     * 申请权限
     * @param permissions 需要申请的权限(数组)
     * @param listener 权限回调接口
     */
    public static void requestPermissions(String[] permissions, PermissionListener listener) {
        Activity activity = ActivityUtils.getTopActivity();
        if (null == activity) {
            return;
        }

        mPermissionListener = listener;
        List<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            //权限没有授权
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }

        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(activity, permissionList.toArray(new String[permissionList.size()]), CODE_REQUEST_PERMISSION);
        } else {
            mPermissionListener.onGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CODE_REQUEST_PERMISSION:
                if (grantResults.length > 0) {
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int result = grantResults[i];
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            String permission = permissions[i];
                            deniedPermissions.add(permission);
                        }
                    }

                    if (deniedPermissions.isEmpty()) {
                        mPermissionListener.onGranted();
                    } else {
                        mPermissionListener.onDenied(deniedPermissions);
                    }
                }
                break;

            default:
                break;
        }
    }

    /**
     * Activity销毁调用生命周期
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();//回退时，网络未取消，取消当前网络请求
        }
        ActivityUtils.removeActivity(this);
    }
    /**
     * 记录是点击时屏幕的Y轴起点
     */
/*    private float startY;
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean isTrue = super.dispatchTouchEvent(ev);//让系统的东西先执行,如果有

        //事件组合一直持续，为保证判定一次，故在MotionEvent.ACTION_UP下执行键盘事件
        View view = this.getCurrentFocus();
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            startY = ev.getY();
        }
        if (view != null && ev.getAction() == MotionEvent.ACTION_UP) {//屏幕上有光标，并且点击区域为EditText
            if (ClickEventUtils.isClickEditText(view, ev) || Math.abs(ev.getY() - startY) > 10) {//点击的是EditText或者手指滑动一段距离都不隐藏
            } else {
                KeyBoardUtils.hideSoftInput(this);
            }
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return isTrue;
    }*/


}
