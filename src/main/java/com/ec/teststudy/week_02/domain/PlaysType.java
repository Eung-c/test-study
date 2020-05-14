package com.ec.teststudy.week_02.domain;

import java.util.Arrays;

public enum PlaysType {

    TRAGEDY("tragedy"),
    COMEDY("comedy");

    private String type;

    PlaysType(String type) {
        this.type = type;
    }

    public static PlaysType findByPlaysType(String type){
        return Arrays.stream(PlaysType.values())
                .filter(playsType -> type.equals(playsType.getType()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("허용되지 않은 연극타입입니다."));
    }

    public String getType() {
        return type;
    }
}
