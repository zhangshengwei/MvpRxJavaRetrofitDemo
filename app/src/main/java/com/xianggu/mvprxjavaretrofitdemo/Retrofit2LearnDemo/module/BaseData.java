package com.xianggu.mvprxjavaretrofitdemo.Retrofit2LearnDemo.module;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-18 19:52
 */
public class BaseData<T> {

    private T data;
    private int code;
    private String msg;
//    private T extra;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public T getExtra() {
//        return extra;
//    }
//
//    public void setExtra(T extra) {
//        this.extra = extra;
//    }
}
