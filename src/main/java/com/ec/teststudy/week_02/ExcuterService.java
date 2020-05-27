package com.ec.teststudy.week_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

public class Excuter {


    R
    CalFactory calFactory = new CalFactory();
    public int excute(String op, int num1, int num2){

        Map<String, Object> map = calFactory.getMap();
        if(!map.containsKey(op))
            throw new IllegalArgumentException("없다");

        Cal cal = (Cal) map.get(op);
        return cal.excuted(num1, num2);

    }
}
