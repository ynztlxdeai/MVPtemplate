package com.vincent.template.app;

import android.app.Application;

import com.vincent.template.R;
import com.vincent.template.utils.ToastUitl;

/**
 * projectName: 	    Template
 * packageName:	        com.vincent.template.app
 * className:	        App
 * author:	            Luoxiang
 * time:	            2017/4/4	15:28
 * desc:	            全局类
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/4/4
 * upDateDesc:	        TODO
 */


public class App extends Application {

    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static App getInstance(){
        return sInstance;
    }

    /**
     * 短暂显示Toast提示(来自String)
     **/
    public void showShortToast(String text) {
        ToastUitl.showShort(text);
    }

    /**
     * 短暂显示Toast提示(id)
     **/
    public void showShortToast(int resId) {
        ToastUitl.showShort(resId);
    }

    /**
     * 长时间显示Toast提示(来自res)
     **/
    public void showLongToast(int resId) {
        ToastUitl.showLong(resId);
    }

    /**
     * 长时间显示Toast提示(来自String)
     **/
    public void showLongToast(String text) {
        ToastUitl.showLong(text);
    }


    public void showToastWithImg(String text, int res) {
        ToastUitl.showToastWithImg(text,res);
    }

    /**
     * 网络访问错误提醒
     */
    public void showNetErrorTip() {
        ToastUitl.showToastWithImg(getText(R.string.net_error).toString(), R.mipmap.ic_wifi_off);
    }

    public void showNetErrorTip(String error) {
        ToastUitl.showToastWithImg(error,R.mipmap.ic_wifi_off);
    }

}
