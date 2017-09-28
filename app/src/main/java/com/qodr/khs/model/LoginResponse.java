package com.qodr.khs.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kodeartisan on 13/09/17.
 */

public class LoginResponse {

    @SerializedName("response")
    private boolean response;

    @SerializedName("code")
    private String code;

    @SerializedName("status")
    private String status;

    @SerializedName("detail")
    private String detail;

    @SerializedName("user")
    private String user;

    @SerializedName("sesi")
    private List<Sesi> sesiList;

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Sesi> getSesiList() {
        return sesiList;
    }

    public void setSesiList(List<Sesi> sesiList) {
        this.sesiList = sesiList;
    }
}
