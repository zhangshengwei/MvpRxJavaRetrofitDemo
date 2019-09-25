package com.xianggu.mvprxjavaretrofitdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.xianggu.mvprxjavaretrofitdemo.R;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.api.Api;

/**
 * @Description: MVP模式
 * @Author: xianggu
 * @CreateDate: 2019-09-17 20:43
 */
public class MvpViewActivity extends AppCompatActivity {


    private Api api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_view);


    }
}
