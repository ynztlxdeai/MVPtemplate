package com.vincent.template.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import androidx.annotation.NonNull;

import com.vincent.template.R;
import com.vincent.template.base.BaseActivity;
import com.vincent.template.databinding.ActivitySplashBinding;


/**
 * projectName: 	    Template
 * packageName:	        com.vincent.template.activity
 * className:	        SplashActivity
 * author:	            Luoxiang
 * time:	            2017/4/5	14:38
 * desc:	            启动页 简单实现 不使用MVP模式
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/4/5
 * upDateDesc:	        TODO
 */


public class SplashActivity
        extends BaseActivity
{


    private com.vincent.template.databinding.ActivitySplashBinding mSplashBinding;

    @Override
    public View getLayout() {
        mSplashBinding = ActivitySplashBinding.inflate(getLayoutInflater());
        return mSplashBinding.getRoot();
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

}
