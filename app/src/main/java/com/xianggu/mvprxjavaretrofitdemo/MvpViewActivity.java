package com.xianggu.mvprxjavaretrofitdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xianggu.mvprxjavaretrofitdemo.mvptemp.MvpContract;
import com.xianggu.mvprxjavaretrofitdemo.mvptemp.base.BaseMvpActivity;
import com.xianggu.mvprxjavaretrofitdemo.mvptemp.presenter.PresenterMvp;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.api.Api;
import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BookBean;

import java.util.List;

/**
 * @Description: MVP模式
 * @Author: xianggu
 * @CreateDate: 2019-09-17 20:43
 */
public class MvpViewActivity extends BaseMvpActivity<PresenterMvp> implements MvpContract.MvpView {

    private static final String TAG = "MvpViewActivity";

    private TextView requestNetTv,resultTv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_view);

        mPresenter = new PresenterMvp();
        mPresenter.attachView(this);

        requestNetTv = findViewById(R.id.requestNetTv);
        resultTv = findViewById(R.id.resultTv);

        requestNetTv.setOnClickListener(v -> {
            mPresenter.bookDataShow();
        });

    }

    @Override
    public void onLoading() {
        String onLoading = "Data Loading...";
        Log.d(TAG,  onLoading);
        Toast.makeText(MvpViewActivity.this,onLoading, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoadSuccess(List<BookBean> bookBeanList) {
        String onLoadSuccess = "Loading Success... ";

        String dataResult = "";
        for (int i = 0; i < bookBeanList.size(); i++) {
            dataResult = dataResult + " 书名 : " + bookBeanList.get(i).getBook_title() + "\t 书ID : " + bookBeanList.get(i).getBook_id() + " \n";
        }
        Log.d(TAG,  onLoadSuccess + " dataContent: " +dataResult);
        Toast.makeText(MvpViewActivity.this, onLoadSuccess, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoadFailed(String error) {
        String onLoadFailed = "Loading Failed..." + error;
        Log.d(TAG, onLoadFailed);
        Toast.makeText(MvpViewActivity.this,onLoadFailed, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoadingView() {
        String showLoadingView = "Loading View...";
        Log.d(TAG, showLoadingView);
        Toast.makeText(MvpViewActivity.this,"Loading View...", Toast.LENGTH_LONG).show();
    }

    @Override
    public void dismissLoadingView() {
        String dismissLoadingView = "Loading Dismissed...";
        Log.d(TAG, dismissLoadingView);
        Toast.makeText(MvpViewActivity.this,dismissLoadingView, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(MvpViewActivity.this,"界面加载失败" + message, Toast.LENGTH_LONG).show();
        finish();
    }
}
