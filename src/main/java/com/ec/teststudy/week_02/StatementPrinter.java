package com.ec.teststudy.week_02;

import com.ec.teststudy.week_02.domain.Invoice;
import com.ec.teststudy.week_02.domain.Performance;
import com.ec.teststudy.week_02.domain.Plays;
import com.ec.teststudy.week_02.domain.PlaysType;
import com.ec.teststudy.week_02.factory.PlaysFactory;

import java.text.DecimalFormat;
import java.util.function.Function;

import static java.lang.Math.floor;


public class StatementPrinter {

    public String statement(Invoice invoice, PlaysFactory plays) throws IllegalArgumentException {
        float totalAmount = 0.0f;
        float volumeCredits = 0.0f;
        String result = String.format("청구 내역 (고객명: %s)", invoice.getCustomer());
        result+= "\n";

        Function<Float, String> format = value -> {
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            return "$" + decimalFormat.format(value);
        };

        for (Performance perf : invoice.getPerformances()) {
            Plays play = plays.getFor(perf.getPlayId());
            float thisAmount = amountFor(perf, play);

            // 포인트를 적립한다.
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if(PlaysType.COMEDY.equals(play.getPlaysInfo().getType()))
                volumeCredits += floor(perf.getAudience() / (double)5);

            // 청구 내역을 출력한다.
            result += String.format("    %s: %s (%d석)",
                    play.getPlaysInfo().getName(),
                    format.apply(thisAmount/100),
                    perf.getAudience());
            result+= "\n";
            totalAmount += thisAmount;
        }

        result += String.format("총액: %s", format.apply(totalAmount/100));
        result+= "\n";
        result += String.format("적립 포인트: %.0f점",volumeCredits);

        return result;
    }

    public float amountFor(Performance perf, Plays play) {
        float thisAmount = 0;
        switch (play.getPlaysInfo().getType()) {
            case TRAGEDY: // 비극
                thisAmount = 40000;
                if(perf.getAudience() > 30){
                    thisAmount += 1000 * (perf.getAudience() - 30);
                }
                break;
            case COMEDY: // 희극
                thisAmount = 30000;
                if(perf.getAudience() > 20){
                    thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                }
                thisAmount += 300 * perf.getAudience();
                break;
            default:
                throw new IllegalArgumentException("알 수 없는 장르" + play.getPlaysInfo().getType().getType());
        }
        return thisAmount;
    }
}
