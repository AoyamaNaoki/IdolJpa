package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	IdolRepository repository;
	
	@RequestMapping("/")
	private ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		Iterable<Idol> list = repository.findAll();
		mav.addObject("data", list);
		return mav;
	}
	
	@RequestMapping("/insert")
	private ModelAndView insert(ModelAndView mav) {
		return mav;
	}
	
	@PostMapping
	@RequestMapping("/show")
	public String create(ModelAndView mav) {
		Idol idol = new Idol();
		idol.setId(100);
		idol.setName("hoge");
		idol.setAge(100);
		repository.save(idol);
		mav.addObject("data",idol);
		return "show";
		//return idolService.create();
	}
	
	@RequestMapping("/update")
	public String update(ModelAndView mav) {
		return "update";
	}
	
	@RequestMapping("/kousin")
	public ModelAndView kousin(ModelAndView mav,@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("age") int age) {
		Idol idol = new Idol();
		idol.setId(id);
		idol.setName(name);
		idol.setAge(age);
		repository.save(idol);
		mav.setViewName("index");
		return mav;
	}
}