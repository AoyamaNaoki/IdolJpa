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
	IdolService idolService;
	
	// INDEXの全てのデータ表示用ページ
	@RequestMapping("/")
	private ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		Iterable<Idol> list = idolService.FindAll();
		mav.addObject("data", list);
		return mav;
	}
	
	// INSERTのフォーム入力用ページ
	@RequestMapping("/insert")
	private ModelAndView insert(ModelAndView mav) {
		return mav;
	}

	// INSERT後のトップへ戻る用のページ
	@RequestMapping("/show")
	public ModelAndView show(ModelAndView mav,@RequestParam("id")int id,@RequestParam("name")String name,@RequestParam("age")int age) {
		Idol idol = idolService.Create(name, age);
		mav.addObject("message","新しいアイドルデータを作成しました");
		mav.setViewName("result");
		return mav;
	}
	
	// UPFATEのフォーム入力用ページ
	@RequestMapping("/update")
	public String update(ModelAndView mav) {
		return "update";
	}
	
	// UPDATE後のトップへ戻る用のページ
	@RequestMapping("/kousin")
	public ModelAndView kousin(ModelAndView mav,@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("age") int age) {
		Idol idol = new Idol();
		idol.setId(id);
		idol.setName(name);
		idol.setAge(age);;
		idolService.Update(idol);
		mav.setViewName("result");
		mav.addObject("message","更新しました");
		return mav;
	}
	
	// DELETEのフォーム入力用ページ
	@RequestMapping("/delete")
	public String delete(ModelAndView mav) {
		return "delete";
	}
	
	// DELETE後のトップへ戻る用のページ
	@RequestMapping("/destroy")
	public ModelAndView destroy(ModelAndView mav,@RequestParam("id")int id) {
		idolService.Delete(id);
		mav.setViewName("result");
		mav.addObject("message","アイドル情報が削除されました");
		return mav;
	}
}