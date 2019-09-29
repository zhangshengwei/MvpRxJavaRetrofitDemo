package com.xianggu.mvprxjavaretrofitdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.api.Api;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BaseData;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BookBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-18 09:41
 */
public class Retrofit2Activity extends AppCompatActivity {

    private static final String TAG = "Retrofit2Activity-->>";

    private TextView requestNetTv, resultTv;

    private Retrofit mRetrofit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refrofit2);
        initView();
        initRetrofit();
    }

    private void initRetrofit() {
        ////步骤4:构建Retrofit实例
        mRetrofit = new Retrofit.Builder()
                //设置网络请求BaseUrl地址
                .baseUrl(Api.BaseURL)
                //设置数据解析器
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void initView() {
        requestNetTv = findViewById(R.id.requestNetTv);
        resultTv = findViewById(R.id.resultTv);

        requestNetTv.setOnClickListener(v -> {
            getRetrofitData();
        });
    }

    private void getRetrofitData() {
        // 步骤5:创建网络请求接口对象实例
        Api api = mRetrofit.create(Api.class);
        //步骤6：对发送请求进行封装
        Call<BaseData<List<BookBean>>> jsonDataCall = api.getBookData();

        //步骤7:发送网络请求(异步)
        jsonDataCall.enqueue(new Callback<BaseData<List<BookBean>>>() {
            @Override
            public void onResponse(Call<BaseData<List<BookBean>>> call, Response<BaseData<List<BookBean>>> response) {
                //步骤8：请求处理,输出结果
                Toast.makeText(Retrofit2Activity.this, "get回调成功:异步执行", Toast.LENGTH_SHORT).show();
                if (response == null) {
                    return;
                }
                BaseData<List<BookBean>> data = response.body();
                if (data == null) {
                    return;
                }
                String resultStr = "";
                for (int i = 0; i < data.getData().size(); i++) {
                    resultStr = resultStr + " 书名 : " + data.getData().get(i).getBook_title() + "\t 书ID : " + data.getData().get(i).getBook_id() + " \n";
                }

                String extraStr = " 总数:" + data.getExtra().getCount() + "\n  页数:" + data.getExtra().getPage() +
                        "\n  一页的数量:" + data.getExtra().getLimit();

                resultTv.setText("dataString:" + resultStr + "\n  补充内容" + extraStr);
            }

            @Override
            public void onFailure(Call<BaseData<List<BookBean>>> call, Throwable t) {
                Log.e(TAG, "get回调失败：" + t.getMessage() + "," + t.toString());
                Toast.makeText(Retrofit2Activity.this, "get回调失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
