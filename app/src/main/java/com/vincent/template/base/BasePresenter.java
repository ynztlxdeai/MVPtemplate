package com.vincent.template.base;

import android.content.Context;

import com.vincent.template.manager.RxManager;

/**
 * packageName:	    com.vincent.template.base
 * className:	    BasePresenter
 * author:	        Luoxiang
 * time:	        2017/4/4	15:07
 * desc:	        基类presenter
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/4/4
 * upDateDesc:      TODO
 */


public abstract class BasePresenter<T,E>{
    public Context mContext;
    public E       mModel;
    public T       mView;
    public RxManager mRxManage = new RxManager();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }
    public void onStart(){

    };
    public void onDestroy() {
        mRxManage.clear();
    }
}
