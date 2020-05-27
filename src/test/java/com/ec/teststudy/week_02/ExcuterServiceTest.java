package com.ec.teststudy.week_02;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ExcuterServiceTest {

    @Test
    public void createInstance(){
        ExcuterService excuterService = new ExcuterService();
        assertNotNull(excuterService);
    }

    @Test
    public void excute_더하기() {
        // given
        ExcuterService excuterService = new ExcuterService();
        int expected = 7;

        // when
        int actual = excuterService.excute("+", 3, 4);

        assertThat(actual, is(expected));
    }

    @Test
    public void excute_빼기() {
        // given
        ExcuterService excuterService = new ExcuterService();
        int expected = -1;

        // when
        int actual = excuterService.excute("-", 3, 4);

        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void excute_에러() {
        // given
        ExcuterService excuterService = new ExcuterService();
        int expected = 7;

        // when
        int actual = excuterService.excute("/", 3, 4);

        assertThat(actual, is(expected));
    }

    @Test
    public void 지환계산기(){
        Repo repo = mock(Repo.class);
        when(repo.getNumber(2)).thenReturn(4);

        ExcuterService excuterService = new ExcuterService();
        excuterService.setRepo(repo);

        System.out.println(excuterService.excute2(2));
    }
}