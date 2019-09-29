package com.xianggu.mvprxjavaretrofitdemo.mvptemp;

import com.xianggu.mvprxjavaretrofitdemo.mvptemp.base.IBaseView;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BaseData;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BookBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;

/**
 * @Description: MVPActivity的接口管理，可以减少大量的接口类
 * @Author: xianggu
 * @CreateDate: 2019-09-26 10:30
 */
public interface MvpContract {

    /**
     * Model 复制数据请求
     */
    interface Model {
        /**
         * 接口请求数据
         */
        Observable<BaseData<List<BookBean>>> getMvpBookList();
    }

    /**
     * 视图渲染
     */
    interface MvpView extends IBaseView {
        @Override
        void showLoadingView();

        @Override
        void dismissLoadingView();

        @Override
        void showMessage(String message);

        /**
         * 数据正在加载中
         */
        void onLoading();

        /**
         * 数据加载成功
         */
        void onLoadSuccess(List<BookBean> bookBeanList);

        /**
         * 数据加载失败
         */
        void onLoadFailed(String error);
    }

    /**
     * 数据请求成功后的处理
     */
    interface Presenter {

        void bookDataShow();
    }


}
