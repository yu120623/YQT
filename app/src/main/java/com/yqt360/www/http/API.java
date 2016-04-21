package com.yqt360.www.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by FreeMason on 2016/4/7.
 */
public class API {
    private static MainAPI mainAPI;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create());
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static MainAPI getMainAPI(){
        if(mainAPI == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.bootcamp.org.cn/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            mainAPI = retrofit.create(MainAPI.class);
        }
        return mainAPI;

    }
}
