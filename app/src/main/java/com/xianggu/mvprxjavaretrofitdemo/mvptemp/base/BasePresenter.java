package com.xianggu.mvprxjavaretrofitdemo.mvptemp.base;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-26 10:48
 */
public class BasePresenter<V extends IBaseView> {
    protected V mView;


    /**
     * 绑定view，一般在初始化中调用该方法
     *
     * @param view view
     */
    public void attachView(V view) {
        this.mView = view;
    }

    /**
     * 解除绑定view，一般在onDestroy中调用
     */

    public void detachView() {
        this.mView = null;
    }

    /**
     * View是否绑定
     *
     * @return
     */
    public boolean isViewAttached() {
        return mView != null;
    }


}
