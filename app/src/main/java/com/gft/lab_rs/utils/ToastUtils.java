package com.gft.lab_rs.utils;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.gft.lab_rs.App;
import com.gft.lab_rs.R;
import com.maning.mndialoglibrary.MToast;
import com.maning.mndialoglibrary.config.MToastConfig;


public class ToastUtils {

	private static Toast mToast;

	public static void showLong(String text) {
		if (mToast == null) {
			mToast = Toast.makeText(App.getApplication(), text, Toast.LENGTH_LONG);

		} else {
			mToast.setText(text);
		}
		mToast.show();
	}

	public static void showShort(String text) {
		if (mToast == null) {
			mToast = Toast.makeText(App.getApplication(), text, Toast.LENGTH_SHORT);

		} else {
			mToast.setText(text);
		}
		mToast.show();
	}

	public static void showMyT(Context context, String content){
		MToastConfig config = new MToastConfig.Builder()
				//设置显示的位置
				.setGravity(MToastConfig.MToastGravity.CENTRE)
				//文字的颜色
				.setTextColor(getMyColor(context,R.color.white))
				//背景色
				.setBackgroundColor(getMyColor(context, R.color.result_view))
				//背景圆角
				.setBackgroundCornerRadius(10)
				//背景边框的颜色
				.setBackgroundStrokeColor(Color.WHITE)
				//背景边框的宽度
				.setBackgroundStrokeWidth(1)

				.build();
		MToast.makeTextShort(context, content, config);
	}



	public static int getMyColor(Context mContext, int colorID) {
		return mContext.getResources().getColor(colorID);
	}

}
