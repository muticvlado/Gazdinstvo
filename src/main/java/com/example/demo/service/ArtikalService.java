package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Artikal;

public interface ArtikalService {
	
	void save(Artikal artikal);
	
	Artikal getById(int id);
	
	List<Artikal> findAll();
	
	void delete(int id);
}
