package com.vincent.template.utils;

import java.lang.reflect.ParameterizedType;

/**
 * packageName:	    com.vincent.template.utils
 * className:	    TUtil
 * author:	        Luoxiang
 * time:	        2017/4/4	15:12
 * desc:	        类转换初始化
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/4/4
 * upDateDesc:      TODO
 */
public class TUtil {
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                                                      .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
