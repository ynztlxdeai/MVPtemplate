package com.vincent.template.base;

import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;

import static android.content.Context.INPUT_METHOD_SERVICE;
/**
 * packageName:	    com.vincent.template.base
 * className:	    BaseEditFragment
 * author:	        Luoxiang
 * time:	        28/05/2019	2:08 PM
 * desc:	        方便调用隐藏键盘
 *
 * svnVersion:
 * upDateAuthor:    luoxiang
 * upDate:          28/05/2019
 * upDateDesc:      方便调用隐藏键盘
 */


public abstract class BaseEditFragment<P extends BasePresenter, M extends BaseModel> extends  BaseFragment<P , M>{

    protected InputMethodManager mInputMethodManager;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInputMethodManager = (InputMethodManager) getContext().getSystemService(INPUT_METHOD_SERVICE);
    }

    protected void hideKeyBoard(IBinder windowToken) {
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (inputMethodManager == null) { return; }
        boolean active = inputMethodManager.isActive();
        if (active) {
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        }
    }
}
