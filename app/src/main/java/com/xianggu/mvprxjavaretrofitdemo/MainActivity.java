package com.xianggu.mvprxjavaretrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView rxJavaTv, retrofit2Tv, toMvpTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rxJavaTv = findViewById(R.id.toRxJava);
        retrofit2Tv = findViewById(R.id.toRetrofit2);
        toMvpTv = findViewById(R.id.toMvp);

        rxJavaTv.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, RxJavaActivity.class));
        });

        retrofit2Tv.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, Retrofit2Activity.class));
        });

        toMvpTv.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MvpViewActivity.class));
        });
    }

}