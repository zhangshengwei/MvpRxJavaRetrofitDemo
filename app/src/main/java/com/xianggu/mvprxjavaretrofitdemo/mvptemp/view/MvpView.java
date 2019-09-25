package com.xianggu.mvprxjavaretrofitdemo.mvptemp.view;

/**
 * @Author: zsw
 * @CreateDate: 2019/9/25 16:48
 * @Description:
 */
public interface MvpView extends IBaseView{

    /**
     * 数据正在加载中
     */
    void onLoading();

    /**
     * 数据加载成功
     */
    void onLoadSuccess();

    /**
     * 数据加载失败
     */
    void onLoadFailed();
}
