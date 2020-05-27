package com.ec.teststudy.week_02;

import java.util.HashMap;
import java.util.Map;

public class CalFactory {

    Map<String, Object> calMap = new HashMap<>();


    public CalFactory(){
        calMap.put("+", new AddCal());
        calMap.put("-", new MinCal());
        calMap.put("*", new MultCal());
    }

    public Map<String, Object> getMap(){
        return calMap;
    }
}
