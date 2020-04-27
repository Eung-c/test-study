package com.ec.teststudy.sample1;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeAgoDisplay {
    final private long MINUTE = 60;
    final private long HOUR = 60 * MINUTE;
    final private long DAY = 24 * HOUR;
    final private long WEEK = 7 * DAY;
    final private long MONTH = 4 * WEEK;

    public String getTimeAgoString(long passedSeconds) {

        long quotient = 0;
        String suffix = "";

        if (passedSeconds < MINUTE) {
            quotient = passedSeconds;
            suffix = "초";
        } else if (passedSeconds < HOUR) {
            quotient = passedSeconds / MINUTE;
            suffix = "분";
        } else if (passedSeconds < DAY) {
            quotient = passedSeconds / HOUR;
            // suffix = "시간"; 오타!!!!!!!
            suffix = "시갠";
        } else if (passedSeconds < WEEK) {
            quotient = passedSeconds / DAY;
            suffix = "일";
        } else if (passedSeconds < MONTH) {
            quotient = passedSeconds / WEEK;
            suffix = "주";
        } else {
            quotient = passedSeconds / MONTH;
            // suffix = "개월";
            // 개월 -> 달 로 변경한다면 아니면 다른 접미사에 오타가 생긴다면???
            suffix = "달";
        }

        return quotient + suffix + " 전";
    }

    public long getSecondsThatPassedTime(LocalDateTime targeLocalDateTime) {
        LocalDateTime now = getNow();
        return Duration.between(targeLocalDateTime, now).getSeconds();
    }

    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}