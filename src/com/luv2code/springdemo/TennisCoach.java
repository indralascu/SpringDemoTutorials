package com.luv2code.springdemo;

import java.io.FileNotFoundException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		
	}
	
	@Override
	public String getDailyWorkout() {
		return "Exercise something backhand volley";
	}

	@Override
	public String getDailyFortune() {
			return fortuneService.getFortune();
	}
	
//	@PostConstruct
//	public void doMyStartupStuff() {
//		System.out.println("TennisCoach: inside of my doMyStartupStuff()");
//	}
	
//	@PreDestroy
//	//For "prototype" scoped beans, Spring does not call the @PreDestroy method
//	public void doMyCleanupStuff() {
//		System.out.println("TennisCoach: inside of my doMyCleanupStuff()");
//	}

}


