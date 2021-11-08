package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Racun;

public interface RacunService {

	void save(Racun racun);
	
	Racun getById(int id);
	
	List<Racun> findAll();
	
	void delete(int id);
}
