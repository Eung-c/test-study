package com.ec.teststudy.week_02.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PerformanceTest {

    private Performance performance;

    @Test
    public void createInstanceTest(){
        performance = new Performance("id", 12);
        assertNotNull(performance);
    }

}