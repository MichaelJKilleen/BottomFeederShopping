package com.bottomfeeder.pos.application;

import com.bottomfeeder.pos.service.MyService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.bottomfeeder.pos")
@RestController
public class BottomFeederApplication {

	private final MyService myService;

	public BottomFeederApplication(MyService myService) {
		this.myService = myService;
	}

	@GetMapping("/")
	public String home() {
		return myService.message();
	}

	public static void main(String[] args) {
		SpringApplication.run(BottomFeederApplication.class, args);
	}
}
