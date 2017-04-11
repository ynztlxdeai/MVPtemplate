package com.vincent.template.manager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * packageName:	    com.vincent.template.manager
 * className:	    ChangeModeHelper
 * author:	        Luoxiang
 * time:	        2017/4/4	15:18
 * desc:	        夜间模式辅助类
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/4/4
 * upDateDesc:      TODO
 */


public class ChangeModeHelper {
    public static final int MODE_DAY = 1;

    public static final int    MODE_NIGHT = 2;
    private static      String Mode       = "mode";
    public static void setChangeMode(Context ctx, int mode){
        SharedPreferences sp = ctx.getSharedPreferences("config_mode", Context.MODE_PRIVATE);
        sp.edit().putInt(Mode, mode).commit();
    }
    public static int getChangeMode(Context ctx){
        SharedPreferences sp = ctx.getSharedPreferences("config_mode", Context.MODE_PRIVATE);
        return sp.getInt(Mode, MODE_DAY);
    }
}
