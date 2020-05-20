package com.ec.teststudy.week_02;

import com.ec.teststudy.week_02.domain.Invoice;
import com.ec.teststudy.week_02.domain.StatementData;
import com.ec.teststudy.week_02.domain.Performance;
import com.ec.teststudy.week_02.domain.Plays;
import com.ec.teststudy.week_02.factory.InvoiceFactory;
import com.ec.teststudy.week_02.factory.PlaysFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
    public void testRenderPlainText() {
        // Setup
        final Invoice invoice = new InvoiceFactory().getInvoice();
        final PlaysFactory plays = new PlaysFactory();
        StatementData statementData = StatementData.builder().build();

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
        String statement = statementPrinterUnderTest.renderPlainText(statementData, invoice, plays);
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
    public void testPlayForTest() {

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

    @Test
    public void testVolumeCreditsFor_C0MEDY() {
        // given
        Performance performance = new Performance("as-like", 35);
        float expected = 12.0f;

        // when
        float actual = statementPrinterUnderTest.volumeCreditsFor(performance);

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void testVolumeCreditsFor_TRAGEDY() {
        // given
        Performance performance = new Performance("hamlet", 55);
        float expected = 25.0f;

        // when
        float actual = statementPrinterUnderTest.volumeCreditsFor(performance);

        // then
        assertThat(actual, is(expected));
    }


    @Test
    public void testFormat() {
        // given
        float float1 = 123.3f;
        String expected1 = "$1.23";


        float float2 = 123344.3f;
        String expected2 = "$1,233.44";

        // when
        String actual1 = statementPrinterUnderTest.usd(float1);
        String actual2 = statementPrinterUnderTest.usd(float2);


        // then
        assertThat(actual1, is(expected1));
        assertThat(actual2, is(expected2));
    }

    @Test
    public void testTotalVolumeCredits() {

        // given
        Invoice invoice = new Invoice("testCustomer", Arrays.asList(new Performance("hamlet", 55)));
        float expected = 25.0f;

        // when
        float actual = statementPrinterUnderTest.totalVolumeCredits(invoice);

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void testAppleSource() {
        // given
        Invoice invoice = new Invoice("testCustomer", Arrays.asList(new Performance("hamlet", 55)));
        float expected = 65000.0f;
        // when
        float actual = statementPrinterUnderTest.totalAmount(invoice);

        // then
        assertThat(actual, is(expected));
    }


}
