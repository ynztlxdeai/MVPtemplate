package com.vincent.template.app;

import android.app.Application;

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
}
