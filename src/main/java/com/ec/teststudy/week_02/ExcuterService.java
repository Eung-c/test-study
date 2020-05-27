package com.ec.teststudy.week_02;

import java.util.Map;

public class ExcuterService {


    Repo repo;
    CalFactory calFactory = new CalFactory();
    public int excute(String op, int num1, int num2){

        Map<String, Object> map = calFactory.getMap();
        if(!map.containsKey(op))
            throw new IllegalArgumentException("없다");

        Cal cal = (Cal) map.get(op);
        return cal.executed(num1, num2);
    }

    public void setRepo(Repo repo){
        this.repo = repo;
    }

    public int excute2(int num1){
        excute3(num1);
        return num1 + repo.getNumber(num1);
    }

    public void excute3(int num1){
        // 디스플레이에 데이터를 전송한다.
        System.out.println(num1);
    }
}
