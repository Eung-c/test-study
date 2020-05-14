package com.ec.teststudy.week_02.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaysTest {

    private Plays plays;

    @Test
    public void createInstanceTest(){
        plays = new Plays("playId", new PlaysInfo("name", PlaysType.COMEDY));
        assertNotNull(plays);
    }
}