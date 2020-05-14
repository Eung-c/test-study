package com.ec.teststudy.week_02;

import com.ec.teststudy.week_02.domain.Invoice;
import com.ec.teststudy.week_02.factory.InvoiceFactory;
import com.ec.teststudy.week_02.factory.PlaysFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StatementPrinterTest {

    private StatementPrinter statementPrinterUnderTest;

    @Before
    public void setUp() {
        statementPrinterUnderTest = new StatementPrinter();
    }

    @Test
    public void testStatement() {
        // Setup
        final Invoice invoice = new InvoiceFactory().getInvoice();
        final PlaysFactory plays = new PlaysFactory();

        String expected = "청구 내역 (고객명: BigCo)" +
                "\n" +
                "    Hamlet: $650.00 (55석)" +
                "\n" +
                "    As You Like It: $580.00 (35석)" +
                "\n" +
                "    Othello: $500.00 (40석)" +
                "\n" +
                "총액: $1,730.00\n" +
                "적립 포인트: 47점";

        // Run the test
        String statement = statementPrinterUnderTest.statement(invoice, plays);
        // Verify the results
        assertEquals(expected, statement);
    }
}
