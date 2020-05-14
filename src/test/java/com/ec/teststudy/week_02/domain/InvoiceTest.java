package com.ec.teststudy.week_02.domain;

import org.junit.Test;

import java.util.Collections;

import static junit.framework.TestCase.assertNotNull;

public class InvoiceTest {

    private Invoice invoiceUnderTest;

    @Test
    public void createInstanceTest(){
        invoiceUnderTest = new Invoice("test", Collections.emptyList());
        assertNotNull(invoiceUnderTest);
    }
}
