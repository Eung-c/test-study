package com.ec.teststudy.week_02.domain;


import org.junit.Test;

import static org.junit.Assert.*;

public class MiddleStructureTest {


    private MiddleStructure middleStructure;

    @Test
    public void createInstanceTest(){
        middleStructure = new MiddleStructure();
        assertNotNull(middleStructure);
    }
}