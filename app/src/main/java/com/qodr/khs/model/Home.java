package com.qodr.khs.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kodeartisan on 28/09/17.
 */

public class Home {

    @SerializedName("nim")
    private String nim;

    @SerializedName("nama")
    private String nama;

    @SerializedName("fakultas")
    private String fakultas;

    @SerializedName("jurusan")
    private String jurusan;

    @SerializedName("angkatan")
    private String angkatan;

    @SerializedName("semester")
    private String semester;

    @SerializedName("ipk")
    private String ipk;

    @SerializedName("sks_sekarang")
    private String sksSekarang;

    @SerializedName("sks_total")
    private String sksTotal;

    @SerializedName("spp")
    private String spp;

    @SerializedName("foto")
    private String foto;

    @SerializedName("status")
    private String status;

    public Home(String nim, String nama, String fakultas, String jurusan, String angkatan, String semester, String ipk, String sksSekarang, String sksTotal, String spp, String foto, String status) {
        this.nim = nim;
        this.nama = nama;
        this.fakultas = fakultas;
        this.jurusan = jurusan;
        this.angkatan = angkatan;
        this.semester = semester;
        this.ipk = ipk;
        this.sksSekarang = sksSekarang;
        this.sksTotal = sksTotal;
        this.spp = spp;
        this.foto = foto;
        this.status = status;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getIpk() {
        return ipk;
    }

    public void setIpk(String ipk) {
        this.ipk = ipk;
    }



    public String getSksTotal() {
        return sksTotal;
    }

    public void setSksTotal(String sksTotal) {
        this.sksTotal = sksTotal;
    }

    public String getSpp() {
        return spp;
    }

    public void setSpp(String spp) {
        this.spp = spp;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSksSekarang() {
        return sksSekarang;
    }

    public void setSksSekarang(String sksSekarang) {
        this.sksSekarang = sksSekarang;
    }
}
