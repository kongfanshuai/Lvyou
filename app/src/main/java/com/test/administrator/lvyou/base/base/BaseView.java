package com.test.administrator.lvyou.base.base;

/**
 * Created by Administrator on 2017/5/16.
 */

public interface BaseView {
    //开始载入
    void onStartLoad();

    //停止载入
    void onStopLoad();

    //加载失败
    void onError(String errorInfo);
}
