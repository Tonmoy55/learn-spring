package com.tonmoy.learnspring;

import com.tonmoy.learnspring.utility.ApplicationContextProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(LearnSpringApplication.class, args);
		var applicationContextProvider= ctx.getBean(ApplicationContextProvider.class);
		applicationContextProvider.setApplicationContext(ctx);
	}


}
