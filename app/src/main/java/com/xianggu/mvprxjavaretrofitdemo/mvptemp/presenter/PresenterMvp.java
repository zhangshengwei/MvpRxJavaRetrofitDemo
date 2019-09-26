package com.xianggu.mvprxjavaretrofitdemo.mvptemp.presenter;

import com.xianggu.mvprxjavaretrofitdemo.mvptemp.MvpContract;
import com.xianggu.mvprxjavaretrofitdemo.mvptemp.base.BasePresenter;
import com.xianggu.mvprxjavaretrofitdemo.mvptemp.model.ModelMvp;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-26 10:49
 */
public class PresenterMvp extends BasePresenter<MvpContract.MvpView> implements MvpContract.Presenter{

    private MvpContract.Model model;

    public PresenterMvp() {
        this.model = new ModelMvp();
    }

    @Override
    public void bookDataShow() {
        // 视图是否已经绑定
        if (!isViewAttached()){
            return;
        }
        
        // TODO: 2019-09-26  使用Rxjava + retrofit 进行数据请求
//        model.getBookData().
        mView.onLoading();                //请求中
//        mView.onLoadSuccess(null);        //请求成功
        mView.onLoadFailed("请求失败测试>>>");           //请求失败

    }
}
