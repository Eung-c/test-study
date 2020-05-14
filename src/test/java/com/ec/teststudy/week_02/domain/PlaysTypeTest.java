package com.ec.teststudy.week_02.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaysTypeTest {


    @Test
    public void getEnum(){
        assertEquals(PlaysType.COMEDY, PlaysType.findByPlaysType("comedy"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void getEnumThrowUnknownType(){
        assertEquals(PlaysType.COMEDY, PlaysType.findByPlaysType("UnknownType"));
    }

}