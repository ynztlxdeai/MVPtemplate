package com.business.business.base;

import android.os.Bundle;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;

/**
 * projectName: 	    Business
 * packageName:	        com.business.business.base
 * className:	        BaseEditActivity
 * author:	            Luoxiang
 * time:	            28/05/2019	2:05 PM
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    luoxiang
 * upDate:	            28/05/2019
 * upDateDesc:	        TODO
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
