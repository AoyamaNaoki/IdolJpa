package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdolService {
	@Autowired
	private IdolRepository idolRepository;
	
	public String create() {
		Idol idol = new Idol();
		idol.setId(0);
		idol.setName("hoge");
		idol.setAge(100);
		idolRepository.save(idol);
		return "Insert Completed";
	}

}
