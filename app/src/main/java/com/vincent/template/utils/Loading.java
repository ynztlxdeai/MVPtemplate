package com.vincent.template.utils;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.vincent.template.R;
import com.vincent.template.views.WinProgress;


/**
 * packageName:	    com.vincent.template.utils
 * className:	    Loading
 * author:	        Luoxiang
 * time:	        2017/4/4	15:24
 * desc:	        进度管理类
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/4/4
 * upDateDesc:      TODO
 */

public class Loading {
    private static WindowManager sManager;
    private static WinProgress   sLoading;

    public static boolean isShowing() {
        return sShowing;
    }

    private static boolean sShowing;

    public static void showLoading(Context context, int rgb){
        if (sShowing){
            return;
        }
        sManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        if (sLoading == null){
            sLoading = (WinProgress) LayoutInflater.from(context)
                                                   .inflate(R.layout.loading, null);
        }
        if (rgb != 0){
            sLoading.setColor(rgb);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.height = (int) DisplayUtil.dp2px(64);
        layoutParams.width = (int) DisplayUtil.dp2px(64);
        layoutParams.format = PixelFormat.TRANSLUCENT;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        sShowing = true;
        sManager.addView(sLoading , layoutParams);
        sLoading.show();
    }

    public static void hideLoading(){
        if (sManager != null){
            if (sShowing){
                sShowing = false;
                sLoading.dismiss();
                sManager.removeView(sLoading);
            }
        }
    }
}
