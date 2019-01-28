package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdolService {
	@Autowired
	private IdolRepository idolRepository;
	
	// FindAllのデータベースを全部て検索するメソッド
	public List<Idol> FindAll() {
		return idolRepository.findAll();
	}
	
	// FindById
	public Idol FindById(int id) {
		return idolRepository.findById(id).orElse(null);
	}
	
	// Insertの新しいデータを追加するメソッド
	public Idol Create(String name,int age) {
		Idol idol = new Idol();
		idol.setName(name);
		idol.setAge(age);
		idol = idolRepository.save(idol);
		return idol;
	}
	
	//	Updateのデータを更新するメソッド
	public Idol Update(Idol idol) {
		idol = idolRepository.save(idol);
		return idol;
	}
	
	//	Deleteでデータを削除する
	public void Delete(int id) {
		idolRepository.deleteById(id);
	}
}
