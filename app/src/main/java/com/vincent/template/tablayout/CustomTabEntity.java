package com.vincent.template.tablayout;

import android.support.annotation.DrawableRes;

/**
 * projectName: 	    Template
 * packageName:	        com.vincent.template.tablayout
 * className:	        CustomTabEntity
 * author:	            Luoxiang
 * time:	            2017/5/17	9:39
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/17
 * upDateDesc:	        TODO
 */
public interface CustomTabEntity {
    String getTabTitle();

    @DrawableRes
    int getTabSelectedIcon();

    @DrawableRes
    int getTabUnselectedIcon();
}
