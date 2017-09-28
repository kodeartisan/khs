package com.qodr.khs.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kodeartisan on 13/09/17.
 */

public class JadwalKuliah {

    @SerializedName("id")
    private String id;

    @SerializedName("nilai")
    private String nilai;

    @SerializedName("semester")
    private String semester;

    @SerializedName("kode_mk")
    private String kodeMk;

    @SerializedName("nama_mk")
    private String namaMk;

    @SerializedName("sks")
    private String sks;

    @SerializedName("kur")
    private String kur;

    @SerializedName("kelas")
    private String kelas;

    @SerializedName("kelp")
    private String kelp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getKodeMk() {
        return kodeMk;
    }

    public void setKodeMk(String kodeMk) {
        this.kodeMk = kodeMk;
    }

    public String getNamaMk() {
        return namaMk;
    }

    public void setNamaMk(String namaMk) {
        this.namaMk = namaMk;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getKur() {
        return kur;
    }

    public void setKur(String kur) {
        this.kur = kur;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKelp() {
        return kelp;
    }

    public void setKelp(String kelp) {
        this.kelp = kelp;
    }
}
