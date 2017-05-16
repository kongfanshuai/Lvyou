package com.test.administrator.lvyou.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/16.
 */

public class NetUtil {
    //判断是否有网
    public static boolean getNetState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            //没有网络的时候淡出提示，返回false
            Toast.makeText(context, "无网络连接，请检查网络", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }

}
