package com.vincent.template.utils;

import android.util.Log;


/**
 * packageName:	    com.vincent.template.utils
 * className:	    Logger
 * author:	        Luoxiang
 * time:	        04/04/2019	3:24 PM
 * desc:	        TODO
 *
 * svnVersion:
 * upDateAuthor:    luoxiang
 * upDate:          04/04/2019
 * upDateDesc:      TODO
 */

public class Logger {
    private static int SYSTEM           = 1;
    private static int VERBOS           = 2;
    private static int DEBUG            = 3;
    private static int INFO             = 4;
    private static int WARN             = 5;
    private static int ERROR            = 6;
     public static int LOG_LEVEL = 0; // 全局的总开关
    public static  int LOG_LEVEL_ON     = ERROR;// 0显示 7隐藏   最低日志显示级别
    public static  int LOG_LEVEL_OFF   = 0;// 0显示 7隐藏   最低日志显示级别
    public static  int LOWEST_LOG_LEVEL = LOG_LEVEL_OFF;// 0显示 7隐藏   最低日志显示级别

    private static final String TAG = "luoxiang";

    public static void i(String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= INFO) {//
            i(TAG, message);
        }
    }

    public static void e(String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= ERROR) {
            e(TAG, message);
        }
    }

    public static void d(String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= DEBUG) {
            d(TAG, message);
        }
    }

    public static void w(String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= WARN) {
            w(TAG, message);
        }
    }

    public static void v(String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= VERBOS) {
            v(TAG, message);
        }
    }

    public static void i(String tag, String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= INFO) {//
            Log.i(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= ERROR) {
            Log.e(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= DEBUG) {
            Log.d(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= WARN) {
            Log.w(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= VERBOS) {
            Log.v(tag, message);
        }
    }

    public static void s(String message) {
        if (message == null) {
            return;
        }
        if (LOWEST_LOG_LEVEL <= SYSTEM) {
            System.out.println(message);
        }
    }

}
