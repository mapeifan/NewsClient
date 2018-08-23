package com.fly.kuaixun.mode;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface NewsService {
    @FormUrlEncoded
    @POST("109-35")
    Observable<ResponseBody> getNewsData(@FieldMap Map<String, String> params);
}
