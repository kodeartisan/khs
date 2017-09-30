package com.qodr.khs.mvp.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.internal.bind.DateTypeAdapter;
import com.qodr.khs.R;
import com.qodr.khs.api.ApiInterface;
import com.qodr.khs.api.ApiUtil;
import com.qodr.khs.base.BaseActivity;
import com.qodr.khs.model.Home;
import com.qodr.khs.model.JadwalKuliah;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends BaseActivity {

    public static final String TAG = HomeActivity.class.getSimpleName();

    private Home mHome;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @BindView(R.id.nama)
    TextView mNama;

    @BindView(R.id.angkatan)
    TextView mAngkatan;

    @BindView(R.id.jurusan)
    TextView mJurusan;

    @BindView(R.id.semester)
    TextView mSemester;

    @BindView(R.id.ipk)
    TextView mIpk;

    @BindView(R.id.sks)
    TextView mSks;

    @BindView(R.id.jumlah_sks)
    TextView mJumlahSks;

    @BindView(R.id.spp)
    TextView mSpp;

    @BindView(R.id.nim)
    TextView mNim;


    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initData() {
        initToolbar();
        getApiHome(new Callback<List<Home>>() {
            @Override
            public void onResponse(Call<List<Home>> call, Response<List<Home>> response) {
                if(response.body().size() > 0) {
                    mHome = response.body().get(0);
                    mNama.setText(mHome.getNama());
                    mJurusan.setText("Jurusan "+ mHome.getJurusan());
                    mAngkatan.setText("Angkatan "+ mHome.getAngkatan());
                    mSemester.setText(mHome.getSemester());
                    mIpk.setText(mHome.getIpk());
                    mSks.setText(mHome.getSksSekarang());
                    mJumlahSks.setText(mHome.getSksTotal());
                    mSpp.setText(mHome.getSpp());
                    mNim.setText("NIM: "+mHome.getNim());


                }
            }

            @Override
            public void onFailure(Call<List<Home>> call, Throwable t) {

            }
        });
    }
}
