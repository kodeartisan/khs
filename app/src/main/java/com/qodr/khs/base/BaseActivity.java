package com.qodr.khs.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.qodr.khs.api.ApiInterface;
import com.qodr.khs.api.ApiService;
import com.qodr.khs.model.Home;
import com.qodr.khs.model.JadwalKuliah;
import com.qodr.khs.model.LoginResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kodeartisan on 28/09/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();

    protected Unbinder mUnbinder;
    protected ApiInterface mService;
    protected Map<String, String> mHeaders = new HashMap<>();

    protected abstract int getLayoutId();
    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        mService = ApiService.createService(ApiInterface.class);
        initData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    protected void getApiJadwalKuliah(final Callback<List<JadwalKuliah>> callback) {
        mHeaders.clear();
        mService.login()
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        String cookie = response.headers().get("Set-Cookie");
                        mHeaders.put("Cookie", cookie);
                        mService.getJadwalKuliah(mHeaders)
                            .enqueue(callback);
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });
    }

    protected void getApiHome(final Callback<List<Home>> callback) {
        mHeaders.clear();
        mService.login()
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        String cookie = response.headers().get("Set-Cookie");
                        mHeaders.put("Cookie", cookie);
                        mService.getHome(mHeaders)
                                .enqueue(callback);
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });
    }
}
