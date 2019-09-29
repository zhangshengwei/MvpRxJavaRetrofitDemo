package com.xianggu.mvprxjavaretrofitdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.xianggu.mvprxjavaretrofitdemo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static java.lang.Thread.sleep;

public class RxJavaActivity extends AppCompatActivity {

    private static final String TAG = "--->>RxJavaActivity";
    private Disposable simpleRxjavaDisposable;
    private Disposable asynChainedRxjavaDisposable;
    private Disposable complexRxjavaDisposable;
    private String[] testData = new String[]{"测试图片 1", "测试图片 2", "测试图片 3", "测试图片 4", "测试图片 5", "测试图片 6", "测试图片 7", "测试图片 8", "测试图片 9", "测试图片 10"};


    private TextView androidID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

        //rxJava 2.0 最简单的使用方法
        rxJavaSimpleUse();

        //rxJava 异步和链式编程
        rxJavaAsyn_Chained();

        //rxJava的复杂应用 需求介绍:
        rxJavaComplicatedUse();
    }

    private void rxJavaSimpleUse() {
        //1.创建: 被观察者
        //Observable:被观察者  ObservableOnSubscribe<T>,可以理解为一个计划表,泛型T是要操作对象的类型
        Observable bookObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                //Emitter是发射器, onNext  onComplete  onError
                //onNext 可以多次调用,所有观察者都能收到
                emitter.onNext("Rxjava 简单操作 1");
                emitter.onNext("Rxjava 简单操作 2");
                emitter.onNext("Rxjava 简单操作 3");
                emitter.onNext("Rxjava 简单操作 4");

                //onComplete 可以重复调用,但观察者只会接收一次
                emitter.onComplete();
                //onError 只能调用一次,需要传递错误信息

            }
        });

        //2.创建: 观察者
        //Observer: 观察者
        Observer<String> reader = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                //可以通过Disposable.dispose() 解除观察者与被观察者的订阅关系
                simpleRxjavaDisposable = d;
            }

            @Override
            public void onNext(String s) {
                //与被观察者的onNext对应
                Log.d(TAG, "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                //与被观察者的onError对应
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                //与被观察者的onComplete对应
                Log.d(TAG, "onComplete: 完成");
            }
        };

        //3.建立被观察者与观察者之间的订阅关系
        bookObservable.subscribe(reader);
    }


    /**
     * 异步+链式变成
     */
    private void rxJavaAsyn_Chained() {
        //Scheduler,英文名调度器,它是RxJava用来控制线程异步

        //创建一个 被观察者
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) {
                emitter.onNext("异步+链式编程 1");
                emitter.onNext("异步+链式编程 2");
                emitter.onNext("异步+链式编程 3");
                emitter.onNext("异步+链式编程 4");
                emitter.onComplete();
            }
        })
                //回调在主线程
                .observeOn(AndroidSchedulers.mainThread())
                //执行在io线程
                .subscribeOn(Schedulers.io())
                //执行 <<观察者>> 操作
                .subscribe(new Observer<String>() {
                    public void onSubscribe(Disposable d) {
                        //可以通过Disposable.dispose() 解除观察者与被观察者的订阅关系
                        asynChainedRxjavaDisposable = d;
                    }

                    @Override
                    public void onNext(String s) {
                        //与被观察者的onNext对应
                        Log.d(TAG, "onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //与被观察者的onError对应
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        //与被观察者的onComplete对应
                        Log.d(TAG, "onComplete: 异步+链式编程 完成");
                    }
                });
    }


    /**
     * 比如我们要依次加载10张图片（加载图片是耗时过程）,
     * 其中第六张我们延时3秒加载,
     * 第7张我们复制到sd卡里,
     * 第8张我们要上网络
     */
    private void rxJavaComplicatedUse() {

        //创建一个 被观察者
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (int i = 0; i < testData.length; i++) {
                    Log.d(TAG, "subscribe: content:" + testData[i]);
                    //第6个图片延时3秒后架子
                    if (i == 5) {
                        sleep(3000);
                        Log.d(TAG, "subscribe: 第五章睡眠3秒");
                    }
                    //复制第7张图片到sd卡
                    if (i == 6) {
                        Log.d(TAG, "subscribe: 第六章保存到SD卡中");
                    }
                    //上传到网络
                    if (i == 7) {
                        Log.d(TAG, "subscribe: 第七张上传到网络");
                    }
                    emitter.onNext(testData[i]);
                }
                emitter.onComplete();
            }
        })      //回调在主线程
                .observeOn(AndroidSchedulers.mainThread())
                //回调在IO线程中执行
                .subscribeOn(Schedulers.io())
                //执行 <<观察者>> 操作
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String string) throws Exception {
                        //回调后在UI界面上展示出来
                        Log.d(TAG, "accept: string:" + string);
                    }
                });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除观察者与被观察者的关系
        simpleRxjavaDisposable.dispose();
        asynChainedRxjavaDisposable.dispose();
        complexRxjavaDisposable.dispose();
    }
}
