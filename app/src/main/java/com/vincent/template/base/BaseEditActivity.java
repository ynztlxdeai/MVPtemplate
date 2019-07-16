package com.vincent.template.base;

import android.os.Bundle;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
/**
 * packageName:	    com.vincent.template.base
 * className:	    BaseEditActivity
 * author:	        Luoxiang
 * time:	        28/05/2019	2:09 PM
 * desc:	        方便调用隐藏键盘
 *
 * svnVersion:
 * upDateAuthor:    luoxiang
 * upDate:          28/05/2019
 * upDateDesc:      方便调用隐藏键盘
 */
public abstract class BaseEditActivity<P extends BasePresenter, M extends BaseModel> extends  BaseActivity<P , M> {
    protected InputMethodManager mInputMethodManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
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
