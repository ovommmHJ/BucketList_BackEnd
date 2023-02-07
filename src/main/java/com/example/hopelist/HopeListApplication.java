package com.example.hopelist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@RestController
public class HopeListApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopeListApplication.class, args);
	}


	@GetMapping("/text")
	public String test(@RequestParam(value="name",defaultValue = "HJ") String name){
		return String.format("Hello~ %s",name);
	}






}
