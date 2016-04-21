package com.yqt360.www.http;

import com.yqt360.www.entity.CompanyList;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by FreeMason on 2016/4/7.
 */
public interface MainAPI {
//    @GET("bootcamp/info/mobile/ajax/{num}")
//    Observable<BcConsulationModel> getNews(@Path("num") int num);

    @GET("getCompanyList")
    Observable<CompanyList> getNews(@Path("num") int num);
}
