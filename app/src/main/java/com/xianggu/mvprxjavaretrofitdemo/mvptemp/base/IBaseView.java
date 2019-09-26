package com.xianggu.mvprxjavaretrofitdemo.mvptemp.base;

/**
 * @Description: 所有View的基类，什么也不做，只是提供一个类型
 * @Author: zsw
 * @CreateDate: 2019/9/25 15:50
 */
public interface IBaseView {

    /**
     * 显示加载界面
     */
    void showLoadingView();

    /**
     * 隐藏加载界面
     */
    void dismissLoadingView();

    /**
     * 显示错误信息
     *
     * @param message
     */
    void showMessage(String message);

}
