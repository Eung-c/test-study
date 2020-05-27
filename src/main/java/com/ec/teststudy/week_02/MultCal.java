package com.ec.teststudy.week_02.factory;

import com.ec.teststudy.week_02.Cal;

public class MultCal implements Cal {
    @Override
    public int excuted(int num1, int num2) {
        return num1 * num2;
    }
}
