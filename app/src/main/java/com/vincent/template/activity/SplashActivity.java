package com.vincent.template.activity;

import android.widget.ImageView;

import com.vincent.template.R;
import com.vincent.template.base.BaseActivity;

import butterknife.BindView;

/**
 * projectName: 	    Template
 * packageName:	        com.vincent.template.activity
 * className:	        SplashActivity
 * author:	            Luoxiang
 * time:	            2017/4/5	14:38
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/4/5
 * upDateDesc:	        TODO
 */


public class SplashActivity
        extends BaseActivity
{
    @BindView(R.id.splash_iv)
    ImageView mSplashIv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mSplashIv.postDelayed(() -> {

        } , 3000);
    }

}
