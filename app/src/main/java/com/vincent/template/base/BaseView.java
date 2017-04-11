package com.vincent.template.base;

/**
 * packageName:	    com.vincent.template.base
 * className:	    BaseView
 * author:	        Luoxiang
 * time:	        2017/4/4	15:16
 * desc:	        baseview
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/4/4
 * upDateDesc:      TODO
 */


public interface BaseView {
    /*******内嵌加载*******/
    void showLoading();
    void stopLoading();
    void showErrorTip(String msg);
}
