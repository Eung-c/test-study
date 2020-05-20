package com.ec.teststudy.week_02;

import com.ec.teststudy.week_02.domain.Invoice;
import com.ec.teststudy.week_02.domain.Performance;
import com.ec.teststudy.week_02.domain.Plays;
import com.ec.teststudy.week_02.factory.InvoiceFactory;
import com.ec.teststudy.week_02.factory.PlaysFactory;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


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

    @Test
    public void testAmountFor_TRAGEDY() {
        // given
        Performance performance = new Performance("hamlet", 55);
        Plays plays = new PlaysFactory().getFor(performance.getPlayId());

        float expected = 65000.0f;

        // when
        float actual = statementPrinterUnderTest.amountFor(performance);

        // then
        assertThat(expected, is(actual));
    }

    @Test
    public void testAmountFor_COMEDY() {
        // given
        Performance performance = new Performance("as-like", 35);
        Plays plays = new PlaysFactory().getFor(performance.getPlayId());

        float expected = 58000.0f;

        // when
        float actual = statementPrinterUnderTest.amountFor(performance);

        // then
        assertThat(expected, is(actual));
    }

    @Test
    public void playForTest() {

        // given
        Performance performance = new Performance("as-like", 35);
        Plays expected = new PlaysFactory().getFor(performance.getPlayId());

        // when
        Plays plays = statementPrinterUnderTest.playFor(performance);

        // then
        assertThat(expected.getPlaysInfo().getType(), is(plays.getPlaysInfo().getType()));
        assertThat(expected.getPlaysInfo().getName(), is(plays.getPlaysInfo().getName()));
        assertThat(performance.getPlayId(), is(plays.getPlayId()));
    }
}
