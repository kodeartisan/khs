package com.qodr.khs.api;

import com.qodr.khs.model.Home;
import com.qodr.khs.model.JadwalKuliah;
import com.qodr.khs.model.LoginResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

/**
 * Created by kodeartisan on 13/09/17.
 */

public interface ApiInterface {

    @GET("sia/api/khs/Ganjil_2015_2016")
    Call<List<JadwalKuliah>> getJadwalKuliah(@HeaderMap Map<String, String> headers);

    @GET("sia/api/home")
    Call<List<Home>> getHome(@HeaderMap Map<String, String> headers);

    @GET("sia/api/signin/151115242/21232f297a57a5a743894a0e4a801fc3")
    Call<LoginResponse> login();

}
