package com.xianggu.mvprxjavaretrofitdemo.mvptemp.presenter;

import com.xianggu.mvprxjavaretrofitdemo.mvptemp.view.IBaseView;

/**
 * @Author: zsw
 * @CreateDate: 2019/9/25 16:31
 * @Description:
 */
public interface BasePresenter<T extends IBaseView> {

    /**
     * 绑定View层
     *
     * @param view
     */
    void attachView(T view);


    /**
     * 解绑View
     */
    void detachView();


    void searchUser(String loginName);
}
