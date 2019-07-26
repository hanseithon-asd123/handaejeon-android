package com.example.handaejeon.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RankingInfo {

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int ranking;

    public int point;

    public RankingInfo(int ranking, int point, String username) {
        this.ranking = ranking;
        this.point = point;
        this.username = username;
    }

    public String username;


}
