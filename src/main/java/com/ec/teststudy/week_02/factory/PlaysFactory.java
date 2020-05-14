package com.ec.teststudy.week_02.factory;

import com.ec.teststudy.week_02.domain.Plays;
import com.ec.teststudy.week_02.domain.PlaysInfo;
import com.ec.teststudy.week_02.domain.PlaysType;

import java.util.*;

public class PlaysFactory {

    private PlaysInfo hamletInfo;
    private PlaysInfo asLikeInfo;
    private PlaysInfo othelloInfo;

    private Plays hamlet;
    private Plays asLike;
    private Plays othello;

    private Map<String, Plays> playsMap;

    public PlaysFactory() {
        this.hamletInfo = new PlaysInfo("Hamlet", PlaysType.findByPlaysType("tragedy"));
        this.asLikeInfo = new PlaysInfo("As You Like It", PlaysType.findByPlaysType("comedy"));
        this.othelloInfo = new PlaysInfo("Othello", PlaysType.findByPlaysType("tragedy"));

        this.hamlet = new Plays("hamlet", hamletInfo);
        this.asLike = new Plays("as-like", asLikeInfo);
        this.othello = new Plays("othello", othelloInfo);

        this.playsMap = new HashMap<>();

        playsMap.put("hamlet", hamlet);
        playsMap.put("as-like", asLike);
        playsMap.put("othello", othello);
    }

    public Plays getFor(String playId){

        if(!playsMap.containsKey(playId))
            throw new IllegalArgumentException("잘못된 playId 입니다.");

        return playsMap.get(playId);
    }
}
