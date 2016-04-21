package com.yqt360.www.home.activity;


import android.util.Log;

import com.yqt360.www.entity.HttpData;

import rx.Subscriber;

/**
 * Created by Administrator on 2016/4/19.
 */
public abstract class SSubscriber extends Subscriber<HttpData> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(HttpData httpData) {
        if(true){
            onSuccess(httpData);
           Log.w("bbb", "=====================================");
        }
        else
            onFailed();
    }

    public abstract void onSuccess(HttpData httpData);
    public abstract void onFailed();
}
