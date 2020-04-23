package com.ec.teststudy.sample1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimeAgoDisplayTest {

    public TimeAgoDisplay timeAgoDisplayTest;
    public LocalDateTime _20200422101010;

    @BeforeEach
    public void init() {
        timeAgoDisplayTest = new TimeAgoDisplay();
        _20200422101010 = LocalDateTime.of(2020, 04, 22, 10, 10, 10);
    }

    @Test
    public void 흐른_초_구하기() {
        // given
        final long expected = 1l;
        timeAgoDisplayTest = new TimeAgoDisplay() {
            @Override
            public LocalDateTime getNow() {
                return LocalDateTime.of(2020, 04, 22, 10, 10, 11);
            }
        };
        LocalDateTime _20200422101010 = LocalDateTime.of(2020, 04, 22, 10, 10, 10);

        // when
        long actual = timeAgoDisplayTest.getSecondsThatPassedTime(_20200422101010);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void 지난시간_표시_초() {
        timeAgoDisplayTest = new TimeAgoDisplay() {
            @Override
            public LocalDateTime getNow() {
                return LocalDateTime.of(2020, 04, 22, 10, 10, 11);
            }
        };
        long secondsThatPassedTime = timeAgoDisplayTest.getSecondsThatPassedTime(_20200422101010);
        String actual = timeAgoDisplayTest.getTimeAgoString(secondsThatPassedTime);

        // then
        assertEquals("1초 전", actual);
    }

    @Test
    public void 지난시간_표시_분() {
        timeAgoDisplayTest = new TimeAgoDisplay() {
            @Override
            public LocalDateTime getNow() {
                return LocalDateTime.of(2020, 04, 22, 10, 11, 10);
            }
        };

        long secondsThatPassedTime = timeAgoDisplayTest.getSecondsThatPassedTime(_20200422101010);
        String actual = timeAgoDisplayTest.getTimeAgoString(secondsThatPassedTime);

        // then
        assertEquals("1분 전", actual);
    }

    @Test
    public void 지난시간_표시_시간() {
        timeAgoDisplayTest = new TimeAgoDisplay() {
            @Override
            public LocalDateTime getNow() {
                return LocalDateTime.of(2020, 04, 22, 11, 10, 10);
            }
        };

        long secondsThatPassedTime = timeAgoDisplayTest.getSecondsThatPassedTime(_20200422101010);
        String actual = timeAgoDisplayTest.getTimeAgoString(secondsThatPassedTime);

        // then
        assertEquals("1시간 전", actual);
    }

    @Test
    public void 지난시간_표시_일() {
        timeAgoDisplayTest = new TimeAgoDisplay() {
            @Override
            public LocalDateTime getNow() {
                return LocalDateTime.of(2020, 04, 23, 10, 10, 10);
            }
        };

        long secondsThatPassedTime = timeAgoDisplayTest.getSecondsThatPassedTime(_20200422101010);
        String actual = timeAgoDisplayTest.getTimeAgoString(secondsThatPassedTime);

        // then
        assertEquals("1일 전", actual);
    }

    @Test
    public void 지난시간_표시_주() {
        timeAgoDisplayTest = new TimeAgoDisplay() {
            @Override
            public LocalDateTime getNow() {
                return LocalDateTime.of(2020, 04, 30, 10, 10, 10);
            }
        };

        long secondsThatPassedTime = timeAgoDisplayTest.getSecondsThatPassedTime(_20200422101010);
        String actual = timeAgoDisplayTest.getTimeAgoString(secondsThatPassedTime);

        // then
        assertEquals("1주 전", actual);
    }

    @Test
    public void 지난시간_표시_개월() {
        timeAgoDisplayTest = new TimeAgoDisplay() {
            @Override
            public LocalDateTime getNow() {
                return LocalDateTime.of(2020, 05, 23, 10, 10, 10);
            }
        };

        long secondsThatPassedTime = timeAgoDisplayTest.getSecondsThatPassedTime(_20200422101010);
        String actual = timeAgoDisplayTest.getTimeAgoString(secondsThatPassedTime);

        // then
        assertEquals("1개월 전", actual);
    }
}