package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Stavka;

public interface StavkaService {

	void save(Stavka stavka);
	
	Stavka getById(int id);
	
	List<Stavka> findAll();
	
	void delete(int id);
}
