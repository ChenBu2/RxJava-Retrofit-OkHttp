package cn.com.san.network.api;


import cn.com.san.config.UrlConfig;
import cn.com.san.network.HttpClient;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * date: Created hongchen on 16/11/05.
 */
public interface TestApi {

    @Headers(HttpClient.CACHE_CONTROL_AGE + HttpClient.CACHE_SHORT)
    @POST(UrlConfig.API_V1_0_TEST)
    Call<Object> test();

    @Headers(HttpClient.CACHE_CONTROL_AGE + HttpClient.CACHE_CONTROL_NETWORK)
    @GET(UrlConfig.door_one)
    Call<Object> door1();

    @Headers(HttpClient.CACHE_CONTROL_AGE + HttpClient.CACHE_CONTROL_NETWORK)
    @GET(UrlConfig.door_two)
    Call<Object> door2();
}
