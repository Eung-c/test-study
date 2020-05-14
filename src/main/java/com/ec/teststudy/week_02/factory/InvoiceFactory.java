package com.ec.teststudy.week_02.factory;

import com.ec.teststudy.week_02.domain.*;

import java.util.Arrays;

public class InvoiceFactory {

    private Performance hamletPerformance;
    private Performance asLikePerformance;
    private Performance othelloPerformance;
    private Invoice invoice;

    public InvoiceFactory() {
        hamletPerformance = new Performance("hamlet", 55);
        asLikePerformance = new Performance("as-like", 35);
        othelloPerformance = new Performance("othello", 40);

        invoice = new Invoice("BigCo", Arrays.asList(hamletPerformance, asLikePerformance, othelloPerformance));
    }

    public Invoice getInvoice(){
        return invoice;
    }
}
