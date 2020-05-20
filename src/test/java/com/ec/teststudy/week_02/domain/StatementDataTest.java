package com.ec.teststudy.week_02.domain;


import org.junit.Test;

import static org.junit.Assert.*;

public class StatementDataTest {


    private StatementData statementData;

    @Test
    public void createInstanceTest(){
        statementData = StatementData.builder().build();
        assertNotNull(statementData);
    }

    @Test
    public void createInstanceTest_addCustomer(){
        statementData = StatementData.builder()
                .customer("customer")
                .build();

        assertNotNull(statementData);
        assertEquals("customer", statementData.getCustomer());
    }
}