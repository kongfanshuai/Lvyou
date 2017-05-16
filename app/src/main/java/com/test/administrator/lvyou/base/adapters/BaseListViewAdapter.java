package com.test.administrator.lvyou.base.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/16.
 */

public class BaseListViewAdapter<T> extends BaseAdapter {
    private List<T> mData;
    private LayoutInflater mInflater;
    private int[] layoutIds;
    public String mType;

    public BaseListViewAdapter(Context context, String mType, List<T> data, int... layoutIds) {
        if (mData != null) {
            this.mData = data;
        } else {
            this.mData = new ArrayList<>();
        }
        this.mType = mType;
        this.mInflater = LayoutInflater.from(context);
        this.layoutIds = layoutIds;
    }


    public void addRes(List<T> data) {
        if (data != null) {
            this.mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void updateRes(List<T> data) {
        if (data != null) {
            this.mData.clear();
            this.mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }


    public static class ViewHolder {
        private View initVeiw;
        private Map<Integer, View> cacheViews;

        public ViewHolder(View initView){
            this.initVeiw = initView;
            cacheViews = new HashMap<>();
        }
        public View findView(int resId){
            View view = null;
            if (cacheViews.containsKey(resId)){
                view = cacheViews.get(resId);
            }else {
                view = initVeiw.findViewById(resId);
                cacheViews.put(resId,view);
            }
            return view;
        }
        public void setText(int resId,String text){
            ((TextView) findView(resId)).setText(text);
        }
    }


}
