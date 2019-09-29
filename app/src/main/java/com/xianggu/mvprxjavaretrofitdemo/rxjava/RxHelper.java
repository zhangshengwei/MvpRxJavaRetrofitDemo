package com.xianggu.mvprxjavaretrofitdemo.rxjava;


import android.text.TextUtils;
import android.util.Log;


import com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module.BaseData;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class RxHelper {

    private static final String TAG = "RxHelper";
    public static final String ERROR = "dataError";

    /**
     * @param showMessage 是否显示成功信息
     * @return 处理结果
     */
    public static <T> ObservableTransformer<BaseData<T>, T> handleResult(final Class<T> defaultEmptyDataClass, final boolean... showMessage) {
        return new ObservableTransformer<BaseData<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseData<T>> upstream) {
                return upstream
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(new Consumer<BaseData<T>>() {
                            @Override
                            public void accept(BaseData<T> result) throws Exception {
                                if (Config.NetWorkResponseCode.RESPONSE_BQG_CODE_SUCCESS.equals(result.getCode()+"")
                                        && isAutoToastMsg(result, showMessage)) {
                                    Log.d(TAG, "RxJavaHelper  accept: " + result.getMsg());
                                }
                            }
                        })
                        .observeOn(Schedulers.io())
                        .flatMap(new Function<BaseData<T>, ObservableSource<T>>() {
                            @Override
                            public ObservableSource<T> apply(BaseData<T> result) throws Exception {
                                if (Config.NetWorkResponseCode.RESPONSE_BQG_CODE_SUCCESS.equals(result.getCode()+"")) {
                                    T data = result.getData();
                                    if (data == null && defaultEmptyDataClass != null) {
                                        data = defaultEmptyDataClass.newInstance();
                                    }
                                    return createObservable(data);
                                } else {
                                    try {
                                        if (!TextUtils.isEmpty(result.getMsg())) {
                                            return Observable.error(new RequestException(
                                                    ERROR + "::: " + (result.getMsg())));
                                        } else {
                                            return Observable.error(new RequestException(
                                                    ERROR + "::: " + "接口返回错误"
                                            ));
                                        }
                                    } catch (Exception e) {
                                        return Observable.error(new RequestException(result.getMsg()));
                                    }
                                }
                            }
                        }).subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 是否自动弹出信息
     *
     * @param result
     * @param showMessage
     * @param <T>
     * @return
     */
    private static <T> boolean isAutoToastMsg(BaseData<T> result, boolean... showMessage) {
        return result != null && showMessage != null && showMessage.length > 0 && showMessage[0];
    }

    /**
     * 创建被观察者
     */
    private static <T> Observable<T> createObservable(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    e.printStackTrace();
                    emitter.onError(e);
                }
            }
        });
    }

}