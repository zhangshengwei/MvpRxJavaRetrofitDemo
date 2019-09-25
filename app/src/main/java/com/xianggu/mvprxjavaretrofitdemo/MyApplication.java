package com.xianggu.mvprxjavaretrofitdemo;

import android.app.Application;
import android.content.Context;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-23 14:41
 */
public class MyApplication extends Application {

    private static Context mContext;
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
