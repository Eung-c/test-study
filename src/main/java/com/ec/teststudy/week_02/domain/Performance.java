package com.ec.teststudy.week_02.domain;

import com.ec.teststudy.week_02.factory.PlaysFactory;

public class Performance {
    private String playId;
    private int audience;


    public Performance(String playId, int audience) {
        this.playId = playId;
        this.audience = audience;
    }

    public String getPlayId() {
        return playId;
    }

    public int getAudience() {
        return audience;
    }

    public Plays getPlay(){
        return new PlaysFactory().getFor(this.getPlayId());
    }
}
