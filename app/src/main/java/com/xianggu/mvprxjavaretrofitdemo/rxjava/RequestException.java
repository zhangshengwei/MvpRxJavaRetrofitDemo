package com.xianggu.mvprxjavaretrofitdemo.rxjava;

/**
 * @author parting_soul
 * @date 2018/3/25
 * 网络请求异常
 */

public class RequestException extends Exception {

    public RequestException(String msg) {
        super(msg);
    }
}
