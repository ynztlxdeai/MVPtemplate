package com.vincent.template.manager;

import android.app.Activity;

import java.util.Stack;

/**
 * packageName:	    com.jinzhi.silucae.manager
 * className:	    AppManager
 * author:	        Luoxiang
 * time:	        2016/9/23	8:47
 * desc:	        activity堆栈式管理
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2016/9/23
 * upDateDesc:      TODO
 */


public class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager      instance;

    private AppManager() {
    }


    /**
     * 结束除了传入的class之外的所有页面
     * @param cls
     */
    public synchronized void singleActivity(Class<?> cls){
        Activity activity = null;
        while (!activityStack.empty()){
            activity = activityStack.peek();
            if (activity != null && !activity.getClass().equals(cls)){
                activityStack.remove(activity);
                activity.finish();
            }else {
                activityStack.remove(activity);
            }
        }
        if (activity != null){
            activityStack.add(activity);
        }
    }

    /**
     * 单一实例
     */
    public static AppManager getAppManager() {
        if (instance == null) {
            synchronized (AppManager.class){
                if (instance == null){
                    instance = new AppManager();
                }
            }
        }

        if (activityStack == null) {
            synchronized (AppManager.class){
                if (activityStack == null){
                    activityStack =  new Stack<Activity>();
                }
            }
        }

        return instance;
    }

    /**
     * 获取指定的Activity
     *
     * @author kymjs
     */
    public static Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        return null;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定的Activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity);
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                finishActivity(activityStack.get(i));
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            finishAllActivity();
            // System.exit(0);
        } catch (Exception e) {
        }
    }
}
