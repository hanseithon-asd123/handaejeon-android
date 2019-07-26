package com.example.handaejeon.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MypageInfo {
    @SerializedName("ranking")
    @Expose
    public int ranking;

    @SerializedName("point")
    @Expose
    public int point;


}
