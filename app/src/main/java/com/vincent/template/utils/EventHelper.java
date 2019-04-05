package com.vincent.template.utils;

import android.view.View;

/**
 * projectName: 	    MVPtemplate
 * packageName:	        com.vincent.template.utils
 * className:	        EventHelper
 * author:	            Luoxiang
 * time:	            05/04/2019	12:51 PM
 * desc:	            触摸事件问题
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    luoxiang
 * upDate:	            05/04/2019
 * upDateDesc:
 */
public class EventHelper {
    /**
     * 用于判断是否处于这个view范围内
     * @param targetView 目标view
     * @param xAxis x
     * @param yAxis y
     * @return 是否范围内
     *
     *          int x = (int) ev.getRawX();
     *         int y = (int) ev.getRawY();
     *         if (isTouchPointInView(mHover, x, y)) {
     *             mBmapView.requestDisallowInterceptTouchEvent(false);
     *             mHover.requestDisallowInterceptTouchEvent(true);
     *             return mRoot.onTouchEvent(ev);
     *         }
     *          return super.dispatchTouchEvent(ev);
     *
     */
    private boolean isTouchPointInView(View targetView, int xAxis, int yAxis) {
        if (targetView == null) {
            return false;
        }
        int[] location = new int[2];
        targetView.getLocationOnScreen(location);
        int left   = location[0];
        int top    = location[1];
        int right  = left + targetView.getMeasuredWidth();
        int bottom = top + targetView.getMeasuredHeight();
        if (yAxis >= top && yAxis <= bottom && xAxis >= left && xAxis <= right) {
            return true;
        }
        return false;
    }

}
