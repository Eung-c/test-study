package com.ec.teststudy.week_02.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaysInfoTest {

    private PlaysInfo playsInfo;
    @Test
    public void createInstanceTest(){

        System.out.println(PlaysType.findByPlaysType("tragedy").name());
        System.out.println(PlaysType.findByPlaysType("tragedy").getType());
        playsInfo = new PlaysInfo("name", PlaysType.findByPlaysType("tragedy"));
        assertNotNull(playsInfo);
    }

}