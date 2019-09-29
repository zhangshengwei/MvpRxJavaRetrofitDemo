package com.xianggu.mvprxjavaretrofitdemo.rxjava;

/**
 * @author parting_soul
 * @date 2018/3/25
 * 解析Json的base bean
 */

public class BaseResponse<T> {
    private T data;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
}
