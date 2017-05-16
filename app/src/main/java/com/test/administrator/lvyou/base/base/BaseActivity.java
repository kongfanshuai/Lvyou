package com.test.administrator.lvyou.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.administrator.lvyou.utils.TypeUtils;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/5/16.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

    public P mPresenter;

    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局前进行的操作
        doBeforLayout();
        //导入布局
        setContentView(getLayoutId());
        //View注入
        ButterKnife.bind(this);
        //初始化Presenter
        mPresenter = TypeUtils.getObject(this, 0);
        //初始化Model
        mModel = TypeUtils.getObject(this, 1);
        //初始化View和Model
        if (mPresenter != null) {
            initPresenter();
        }
        //初始化View
        this.initView();
    }

    protected void doBeforLayout() {

    }

    protected abstract int getLayoutId();

    protected abstract void initPresenter();

    protected abstract void initView();

}
