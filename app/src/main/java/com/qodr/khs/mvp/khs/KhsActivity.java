package com.qodr.khs.mvp.khs;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.qodr.khs.JadwalKuliahAdapter;
import com.qodr.khs.R;
import com.qodr.khs.api.ApiInterface;
import com.qodr.khs.api.ApiService;
import com.qodr.khs.base.BaseActivity;
import com.qodr.khs.model.JadwalKuliah;
import com.qodr.khs.model.LoginResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class KhsActivity extends AppCompatActivity {

    public static final String TAG = KhsActivity.class.getSimpleName();

    protected List<JadwalKuliah> mJadwalKuliah = new ArrayList<>();

    private Map<String, String> mHeaders = new HashMap<>();

    private ApiInterface mService;

    private RecyclerView mRecyclerview;

    private Toolbar mToolbar;

    private DrawerLayout mDrawerLayout;

    private JadwalKuliahAdapter mJadwalKuliahAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        initToolbar();
        initDrawer();
        initRecyclerview();

        mService = ApiService.createService(ApiInterface.class);
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
                                        mJadwalKuliahAdapter.addData(mJadwalKuliah);
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
    }

    private void initRecyclerview() {
        mJadwalKuliahAdapter = new JadwalKuliahAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.setAdapter(mJadwalKuliahAdapter);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setItemAnimator(new DefaultItemAnimator());
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void initDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.right_menu, menu);

        return  true;
    }


}
