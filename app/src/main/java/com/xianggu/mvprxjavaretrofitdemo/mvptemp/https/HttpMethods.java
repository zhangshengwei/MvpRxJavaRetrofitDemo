package com.xianggu.mvprxjavaretrofitdemo.mvptemp.https;

import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.api.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-27 11:31
 */
public class HttpMethods {

    /**
     * 接口请求Base地址
     */
    public static final String BASE_URL = "https://api.douban.com/v2/movie/";

    /**
     * 默认请求超时时间
     */
    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit mRetrofit;
    private Api apiData;
    /**
     * 单例对象
     */
    private volatile static HttpMethods instance;

    public static HttpMethods getInstance() {
        if (instance == null) {
            synchronized (HttpMethods.class) {
                instance = new HttpMethods();
            }
        }
        return instance;
    }


    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                //设置网络请求BaseUrl地址
                .baseUrl(Api.BaseURL)
                //设置数据解析器
                .addConverterFactory(GsonConverterFactory.create())
                //配置回调库，采用RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiData = mRetrofit.create(Api.class);
    }

    public Api getApi() {
        return apiData;
    }
}
