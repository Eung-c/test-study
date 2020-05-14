package com.ec.teststudy.week_02.domain;

public class PlaysInfo {
    private String name;
    private PlaysType type;

    public PlaysInfo(String name, PlaysType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public PlaysType getType() {
        return type;
    }
}
