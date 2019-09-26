package com.xianggu.mvprxjavaretrofitdemo.mvptemp.model;

import com.xianggu.mvprxjavaretrofitdemo.mvptemp.MvpContract;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BaseData;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BookBean;

import org.reactivestreams.Subscriber;

import java.util.List;

import retrofit2.Call;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-26 10:41
 */
public class ModelMvp implements MvpContract.Model {

    @Override
    public Call<BaseData<List<BookBean>>> getBookData() {
        // 网络请求
        return null;
    }
}
