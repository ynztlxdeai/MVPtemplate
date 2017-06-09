package com.vincent.template.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.vincent.template.app.App;

/**
 * projectName: 	    Template
 * packageName:	        com.vincent.template.utils
 * className:	        DisplayUtil
 * author:	            Luoxiang
 * time:	            2017/4/4	15:26
 * desc:	            dp和px转换
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/4/4
 * upDateDesc:	        TODO
 */
public class DisplayUtil {
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
