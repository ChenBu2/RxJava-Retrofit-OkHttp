package cn.com.san.network;



import cn.com.san.config.UrlConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date: Created hongchen on 16/11/05.
 */
public class RetrofitManager {

    private static Retrofit mTestRetrofit;

    public static Retrofit getTestRetrofit(){
        if (mTestRetrofit == null) {
            synchronized (RetrofitManager.class) {
                mTestRetrofit = new Retrofit.Builder().baseUrl(UrlConfig.TestHostUrl)
                        .client(HttpClient.mOkHttpClient)
//                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }
        return mTestRetrofit;
    }

}
