package com.ec.teststudy.week_02;

import com.ec.teststudy.week_02.Cal;

public class MyCal implements Cal{
    @Override
    public int executed(int num1, int num2) {
        return num1 * num2 + num1;
    }
}
