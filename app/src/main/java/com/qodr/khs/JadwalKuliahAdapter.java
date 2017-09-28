package com.qodr.khs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qodr.khs.model.JadwalKuliah;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kodeartisan on 19/09/17.
 */

public class JadwalKuliahAdapter extends RecyclerView.Adapter<JadwalKuliahAdapter.MyViewHolder> {

    private List<JadwalKuliah> mJadwalKuliahList = new ArrayList<>();

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_jadwal, parent, false);

        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        JadwalKuliah jadwalKuliah = mJadwalKuliahList.get(position);
        holder.mNilai.setText(jadwalKuliah.getNilai());
    }

    @Override
    public int getItemCount() {
        return mJadwalKuliahList.size();
    }

    public void addData(List<JadwalKuliah> jadwalKuliahList) {
        this.mJadwalKuliahList = jadwalKuliahList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mNilai;

        public MyViewHolder(View itemView) {
            super(itemView);

            mNilai = (TextView) itemView.findViewById(R.id.txtNilai);
        }
    }
}
