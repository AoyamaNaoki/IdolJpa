package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	//
	@RequestMapping("/show")
	private ModelAndView show(ModelAndView mav) {
//		Idol idol = repository.findById(id).orElse(null);
//		repository.save(idol);
//		mav.addObject("data",idol);
		mav.setViewName("show");
		return mav;
	}
	
}