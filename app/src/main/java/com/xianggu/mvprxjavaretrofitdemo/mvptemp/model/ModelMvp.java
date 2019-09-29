package com.xianggu.mvprxjavaretrofitdemo.mvptemp.model;

import com.xianggu.mvprxjavaretrofitdemo.mvptemp.MvpContract;
import com.xianggu.mvprxjavaretrofitdemo.mvptemp.https.HttpMethods;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BaseData;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BookBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * @Description: 负责提供数据
 * @Author: xianggu
 * @CreateDate: 2019-09-26 10:41
 */
public class ModelMvp implements MvpContract.Model {


    @Override
    public Observable<BaseData<List<BookBean>>> getMvpBookList() {
        // 网络请求
        return HttpMethods.getInstance().getApi().getMvpBookData();
    }
}
