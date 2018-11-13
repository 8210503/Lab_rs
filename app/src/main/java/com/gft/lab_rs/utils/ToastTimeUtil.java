package com.gft.lab_rs.utils;

import android.content.Context;
import android.view.View;
import android.widget.TextView;


import com.bigkoo.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/6/12.
 * 时间选择器
 */
public class ToastTimeUtil {

    public static void getYouTime(Context context, final TextView timeTv) {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(1970, 0, 1);
        Calendar endDate = Calendar.getInstance();
//        endDate.set(2030, 1, 1);
        Date date = new Date(System.currentTimeMillis());
        endDate.setTime(date);
        TimePickerView pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(java.util.Date date, View v) {//选中事件回调
                timeTv.setText(getTime(date));
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)//默认全部显示至时分秒
                .setContentSize(18)//滚轮文字大小
                .setTitleSize(20)//标题文字大小
                .setTitleText("选择时间")//标题文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTitleColor(0xFFEE7621)//标题文字颜色
                .setSubmitColor(0xFFEE7621)//确定按钮文字颜色
                .setCancelColor(0xFFEE7621)//取消按钮文字颜色
                .setTitleBgColor(0xFF4F94CD)//标题背景颜色 Night mode
//                .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("年", "月", "日", "时", "分", "秒")


                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(false)//是否显示为对话框样式
                .build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();

    }

    public static void getMinuteTime(Context context, final TextView timeTv) {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(1970, 0, 1);
        Calendar endDate = Calendar.getInstance();
        //        endDate.set(2030, 1, 1);
        Date date = new Date(System.currentTimeMillis());
        endDate.setTime(date);
        TimePickerView pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(java.util.Date date, View v) {//选中事件回调
                timeTv.setText(getMTime(date));
            }
        })
                .setType(TimePickerView.Type.HOURS_MINS)//默认全部显示至时分秒
                .setContentSize(18)//滚轮文字大小
                .setTitleSize(20)//标题文字大小
                .setTitleText("选择时间")//标题文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTitleColor(0xFFEE7621)//标题文字颜色
                .setSubmitColor(0xFFEE7621)//确定按钮文字颜色
                .setCancelColor(0xFFEE7621)//取消按钮文字颜色
                .setTitleBgColor(0xFF4F94CD)//标题背景颜色 Night mode
                //                .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
                //                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("年", "月", "日", "时", "分", "秒")


                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(false)//是否显示为对话框样式
                .build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();

    }

    public static String getMTime(java.util.Date date) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm ", Locale.CHINA);
        return format.format(date);
    }

    public static String getTime(java.util.Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ", Locale.CHINA);
        return format.format(date);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getNowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
}
