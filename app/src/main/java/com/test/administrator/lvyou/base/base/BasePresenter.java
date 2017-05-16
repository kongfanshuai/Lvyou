package com.test.administrator.lvyou.base.base;

/**
 * Created by Administrator on 2017/5/16.
 */

public abstract class BasePresenter<M extends BaseModel, V extends BaseView> {

    public M mModel;

    public V mView;

    public BasePresenter(){

    }

    public void setMV(M model,V view){
        mModel = model;
        mView = view;
    }
}
