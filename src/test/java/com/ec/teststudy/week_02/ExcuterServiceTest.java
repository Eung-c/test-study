package com.ec.teststudy.week_02;

import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExcuterTest {





    @Test
    public void createInstance(){
        Excuter excuter = new Excuter();
        assertNotNull(excuter);
    }

    @Test
    public void excute_더하기() {
        // given
        Excuter excuter = new Excuter();
        int expected = 7;

        // when
        int actual = excuter.excute("+", 3, 4);

        assertThat(actual, is(expected));
    }

    @Test
    public void excute_빼기() {
        // given
        Excuter excuter = new Excuter();
        int expected = -1;

        // when
        int actual = excuter.excute("-", 3, 4);

        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void excute_에러() {
        // given
        Excuter excuter = new Excuter();
        int expected = 7;

        // when
        int actual = excuter.excute("/", 3, 4);

        assertThat(actual, is(expected));
    }

    @Test
    public void 지환계산기(){
        Cal mock = mock(Cal.class);
        when(mock.excuted(4, 5)).thenReturn(10);

        assertEquals(mock.excuted(4, 5), 10);


    }
}