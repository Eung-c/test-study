package com.ec.teststudy.week_02;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CalFactoryTest {



    @Test
    public void TestGetMap(){
        CalFactory calFactory = new CalFactory();
        Map<String, Object> map = calFactory.getMap();

        assertNotNull(map);
    }




}