package com.example.handaejeon.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RankingInfo {
    @SerializedName("ranking")
    @Expose
    public int ranking;

    @SerializedName("point")
    @Expose
    public int point;

    @SerializedName("username")
    @Expose
    public int username;


}
