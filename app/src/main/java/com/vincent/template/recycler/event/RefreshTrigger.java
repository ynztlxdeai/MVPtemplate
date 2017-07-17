package com.vincent.template.recycler.event;
/**
 * packageName:	    com.vincent.template.recycler.event
 * className:	    RefreshTrigger
 * author:	        Luoxiang
 * time:	        2017/7/17	14:58
 * desc:	        刷新触发器
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/7/17
 * upDateDesc:      TODO
 */
public interface RefreshTrigger {

    void onStart(boolean automatic, int headerHeight, int finalHeight);

    void onMove(boolean finished, boolean automatic, int moved);

    void onRefresh();

    void onRelease();

    void onComplete();

    void onReset();
}
