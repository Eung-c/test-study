package com.ec.teststudy.week_02.factory;

import com.ec.teststudy.week_02.domain.Performance;
import com.ec.teststudy.week_02.domain.Plays;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PlaysFactoryTest {

    private PlaysFactory playsFactory;

    @Test
    public void createInstanceTest(){

        playsFactory = new PlaysFactory();
        assertNotNull(playsFactory);

    }

    @Test
    public void createPlay(){
        // given
        Performance performance = new Performance("as-like", 35);
        Plays expected = new PlaysFactory().getFor(performance.getPlayId());
        String expectedName = "As You Like It";

        assertThat(expectedName, is(expected.getPlaysInfo().getName()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void createWrongPlay(){
        // given
        Performance performance = new Performance("wrong-play", 35);
        Plays expected = new PlaysFactory().getFor(performance.getPlayId());
    }
}