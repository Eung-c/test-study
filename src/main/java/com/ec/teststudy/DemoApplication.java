package com.ec.teststudy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoApplication.class).web(WebApplicationType.NONE).run(args);
	}

}
