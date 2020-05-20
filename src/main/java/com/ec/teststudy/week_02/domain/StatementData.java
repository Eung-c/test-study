package com.ec.teststudy.week_02.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class StatementData {

    private String customer;
    private List<Performance> performances;
}
