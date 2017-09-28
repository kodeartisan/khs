package com.qodr.khs.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kodeartisan on 13/09/17.
 */

public class ApiService {

    public static final String TAG = ApiService.class.getSimpleName();

    public static final String ROOT_URL = "http://128.199.196.3/";

    private static Retrofit provideRetrofitBuilder() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .client(httpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient httpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    public static <S> S createService(Class<S> serviceClass) {
        return provideRetrofitBuilder().create(serviceClass);
    }


}
