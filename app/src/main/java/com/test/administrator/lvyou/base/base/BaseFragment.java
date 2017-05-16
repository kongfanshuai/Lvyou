package com.test.administrator.lvyou.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.administrator.lvyou.utils.TypeUtils;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/5/16.
 */

public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {

    protected View layout;
    public P mPresenter;
    public M mModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //设置布局前的操作
        doBeforeLayout();
        //初始化布局
        if (layout == null) {
            layout = inflater.inflate(getLayoutId(), container, false);
        }
        //注入View
        ButterKnife.bind(this, layout);
        //初始化Presenter
        mPresenter = TypeUtils.getObject(this, 0);
        //初始化Model
        mModel = TypeUtils.getObject(this, 1);
        //初始化View和Model
        if (mPresenter != null) {
            initPresenter();
        }
        //初始化View;
        this.initView();

        return layout;
    }

    protected  void doBeforeLayout(){

    }

    protected abstract int getLayoutId();

    protected abstract void initPresenter();

    protected abstract void initView();
}
