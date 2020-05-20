package com.ec.teststudy.week_02.domain;


import org.junit.Test;

import static org.junit.Assert.*;

public class StatementDataTest {


    private StatementData statementData;

    @Test
    public void createInstanceTest(){
        statementData = new StatementData();
        assertNotNull(statementData);
    }
}