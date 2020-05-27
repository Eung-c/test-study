package com.ec.teststudy.week_02;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyCalTest {


    @Test
    public void testExcuted(){
        MyCal myCal = new MyCal();

        myCal.executed(3, 4);
        assertThat(myCal.executed(3, 4), is(15));
    }





}