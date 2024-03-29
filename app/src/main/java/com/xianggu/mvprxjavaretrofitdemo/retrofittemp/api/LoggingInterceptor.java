package com.xianggu.mvprxjavaretrofitdemo.retrofittemp.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by ${JokerWan} on 2017/9/22.
 * WeChat：wjc398556712
 * Function：打印请求参数和返回结果
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        Request request = chain.request();
        //请求发起的时间
        long t1 = System.nanoTime();

        Log.e("LoggingInterceptor", String.format("发送请求 %s on %s%n%s", request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);
        //收到响应的时间
        long t2 = System.nanoTime();

        //这里不能直接使用response.body().string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
        //个新的response给应用层处理
        ResponseBody responseBody = response.peekBody(1024 * 1024);

//        com.orhanobut.logger.Logger.e(String.format(Locale.getDefault(), "接收响应: [%s] %n返回json:【%s】 %.1fms",
//                response.request().url(),
//                responseBody.string(),
//                (t2 - t1) / 1e6d));
        Log.e("LoggingInterceptor", responseBody.string());
        return response;
    }
}
