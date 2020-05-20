package com.ec.teststudy.week_02.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PerformanceTest {

    private Performance performance;

    @Test
    public void createInstanceTest(){
        performance = new Performance("id", 12);
        assertNotNull(performance);
    }

    @Test
    public void getPlay() {
        performance = new Performance("hamlet", 55);
        performance.getPlay();

        assertThat("Hamlet", is(performance.getPlay().getPlaysInfo().getName()));
    }
}