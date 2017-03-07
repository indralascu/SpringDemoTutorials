package com.luv2code.springdemo;

import java.io.FileNotFoundException;

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
		try {
			return fortuneService.getFortune();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
