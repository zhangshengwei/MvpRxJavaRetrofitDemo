package com.xianggu.mvprxjavaretrofitdemo.mvptemp.presenter;

import com.xianggu.mvprxjavaretrofitdemo.mvptemp.MvpContract;
import com.xianggu.mvprxjavaretrofitdemo.mvptemp.base.BasePresenter;
import com.xianggu.mvprxjavaretrofitdemo.mvptemp.https.HttpMethods;
import com.xianggu.mvprxjavaretrofitdemo.mvptemp.model.ModelMvp;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BookBean;
import com.xianggu.mvprxjavaretrofitdemo.rxjava.RxHelper;
import com.xianggu.mvprxjavaretrofitdemo.rxjava.RxObserver;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-26 10:49
 */
public class PresenterMvp extends BasePresenter<MvpContract.MvpView> implements MvpContract.Presenter {

    private MvpContract.Model model;


    public PresenterMvp() {
        this.model = new ModelMvp();
    }

    @Override
    public void bookDataShow() {
        // 视图是否已经绑定
        if (!isViewAttached()) {
            return;
        }

        // TODO: 2019-09-26  使用Rxjava + retrofit 进行数据请求
        model.getMvpBookList()
                .compose(RxHelper.handleResult(null))
                .subscribe(new RxObserver<List<BookBean>>() {
                    @Override
                    protected void onSuccess(List<BookBean> bookBeanList) {
                        //请求成功
                        mView.onLoadSuccess(bookBeanList);
                    }

                    @Override
                    public void onError(String error) {
                        //请求失败
                        mView.onLoadFailed("请求失败测试>>> 失败原因:" + error);
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        //可以通过Disposable.dispose() 解除观察者与被观察者的订阅关系
                    }
                });

    }
}
