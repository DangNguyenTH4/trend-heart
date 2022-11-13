package com.sunteco.young.loveevent;

import com.sunteco.young.loveevent.config.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource(value = "classpath:/application.yaml", encoding = "UTF-8")
public class LoveEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveEventApplication.class, args);
	}
	@Autowired
	Environment env;

	@Bean
	public UserService userService(){
		String u1 = env.getProperty("label.user1");
		String u2 =env.getProperty("label.user2");
		boolean allow = env.getProperty("label.allow-update", Boolean.class, true);
		return new UserService(u1, u2, allow);
	}
}
