package com.ec.teststudy.week_02.factory;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaysFactoryTest {

    private PlaysFactory playsFactory;

    @Test
    public void createInstanceTest(){

        playsFactory = new PlaysFactory();
        assertNotNull(playsFactory);

    }
}