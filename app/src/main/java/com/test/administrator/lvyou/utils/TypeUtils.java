package com.test.administrator.lvyou.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Administrator on 2017/5/16.
 */

public class TypeUtils {
    public static <T> T getObject(Object object, int index) {
        ParameterizedType[] genericInterfaces = (ParameterizedType[]) object.getClass().getGenericInterfaces();
        try {
            T t = (T) genericInterfaces[index].getActualTypeArguments().getClass().newInstance();
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
