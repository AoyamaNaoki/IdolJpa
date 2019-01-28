package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdolJpaApplicationTests {

	@Autowired
	private IdolRepository idolRepository;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void idolTest() {
		Idol idol = new Idol();
		idol.setId(0);
		idol.setName("aaa");
		idol.setAge(100);
		idolRepository.save(idol);
	}
	
	@Test
	public void aaa() {
		Iterable<Idol> list = idolRepository.findAll();
		System.out.println("OK");
	}
	
	@Test
	public void test3() {
		Idol idol = new Idol();
		idol.setAge(1);
		idol.setName("aa");
		idol.setId(1);
		idolRepository.save(idol);
	}
}

