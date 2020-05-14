package com.ec.teststudy.week_02.domain;

public class Plays {
    private String playId;
    private PlaysInfo playsInfo;

    public Plays(String playId, PlaysInfo playsInfo) {
        this.playId = playId;
        this.playsInfo = playsInfo;
    }

    public String getPlayId() {
        return playId;
    }

    public PlaysInfo getPlaysInfo() {
        return playsInfo;
    }
}
