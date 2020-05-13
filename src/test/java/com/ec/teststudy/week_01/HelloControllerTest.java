package com.ec.teststudy.week_01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 1. 기본 JUnit Runner 변경 / 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) // 2. WebMvcText Controller를 테스트 하기 위한 어노테이션
public class HelloControllerTest {
//test
    @Autowired // 스프링이 관리하는 HelloController bean 을 주입받음
    private MockMvc mockMvc; // 4. 웹 Api를 테스트 할때 사용, http에 다양한 메소드를 테스트 가능

    @Test
    public void hello_리턴() throws Exception{
        String hello = "hello";

        mockMvc.perform(get("/hello")) // 5. "/hello"  주소로 get http 요청
                    .andExpect(status().isOk()) // 6. 반환 값이 200 인지 체크
                    .andExpect(content().string(hello)); // 7. 응답 내용이 "hello" 인지 확인
    }
}