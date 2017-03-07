package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
 
	List<String> fortunes;
	Random random = new Random();
	@Override
	public String getFortune() throws FileNotFoundException {
		fortunes = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new FileReader("File/fortunes.txt"));
		
		try {
			String line = in.readLine();
			while(line != null) {
				fortunes.add(line);
				line = in.readLine();
			}
		 in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fortunes.get(random.nextInt(fortunes.size()));
	}

}
