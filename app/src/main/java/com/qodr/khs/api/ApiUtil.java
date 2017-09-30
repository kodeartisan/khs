package com.qodr.khs.api;

import com.qodr.khs.model.JadwalKuliah;
import com.qodr.khs.model.LoginResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kodeartisan on 28/09/17.
 */

public class ApiUtil {

    private static ApiInterface mService;
    private static ApiUtil mInstance;
    private Map<String, String> mHeaders = new HashMap<>();
    protected List<JadwalKuliah> mJadwalKuliah = new ArrayList<>();

    public static ApiUtil newInstance() {
        if(mService == null) {
            mService = ApiService.createService(ApiInterface.class);
        }

        if(mInstance == null) {
            mInstance = new ApiUtil();
        }

        return mInstance;
    }

    public List<JadwalKuliah> getJadwalKuliah() {
        mHeaders.clear();
        mJadwalKuliah.clear();
        mService.login()
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        String cookie = response.headers().get("Set-Cookie");
                        mHeaders.put("Cookie", cookie);
                        mService.getJadwalKuliah(mHeaders)
                                .enqueue(new Callback<List<JadwalKuliah>>() {
                                    @Override
                                    public void onResponse(Call<List<JadwalKuliah>> call, Response<List<JadwalKuliah>> response) {
                                        mJadwalKuliah = response.body();
                                    }

                                    @Override
                                    public void onFailure(Call<List<JadwalKuliah>> call, Throwable t) {

                                    }
                                });


                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

        return mJadwalKuliah;

    }

    private void login() {
        mHeaders.clear();

    }
}
