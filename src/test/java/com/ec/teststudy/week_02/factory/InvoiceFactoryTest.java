package com.ec.teststudy.week_02.factory;

import org.junit.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

public class InvoiceFactoryTest {

    private InvoiceFactory invoiceFactoryUnderTest;

    @Test
    public void createInstanceTest(){
        invoiceFactoryUnderTest = new InvoiceFactory();
        assertNotNull(invoiceFactoryUnderTest);
    }


}
