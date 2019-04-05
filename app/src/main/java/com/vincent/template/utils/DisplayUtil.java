package com.vincent.template.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

import com.vincent.template.app.App;


/**
 * packageName:	    com.vincent.template.utils
 * className:	    DisplayUtil
 * author:	        Luoxiang
 * time:	        04/04/2019	9:34 PM
 * desc:	        TODO
 *
 * svnVersion:
 * upDateAuthor:    luoxiang
 * upDate:          04/04/2019
 * upDateDesc:      TODO
 */


public class DisplayUtil {

    private static int screenWidth = 0;
    private static int screenHeight = 0;
    public static int getWidth(Context context) {
        if (screenWidth <=0) {
            readScreenInfo(context);
        }
        return screenWidth;
    }


    public static int getHeight(Context context) {
        if (screenHeight <= 0) {
            readScreenInfo(context);
        }
        return screenHeight;
    }


    public static void readScreenInfo(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics );
        screenHeight =outMetrics.heightPixels;
        screenWidth = outMetrics.widthPixels;
    }

    /**
     * Change SP to PX
     *
     * @param resources Resources
     * @param sp        SP
     * @return PX
     */
    public static float spToPx(Resources resources, float sp) {
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, metrics);
    }

    /**
     * Change Dip to PX
     *
     * @param resources Resources
     * @param dp        Dip
     * @return PX
     */
    public static float dipToPx(Resources resources, float dp) {
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics);
    }

    public static float dp2px(float dp) {
        return dp * getDisplayMetrics().density;
    }

    public static float px2dp(float px) {
        return px / getDisplayMetrics().density;
    }

    public static DisplayMetrics getDisplayMetrics() {
        return App.getInstance().getResources().getDisplayMetrics();
    }
}
