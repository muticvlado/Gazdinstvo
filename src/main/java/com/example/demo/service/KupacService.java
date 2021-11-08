package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Kupac;

public interface KupacService {

	void save(Kupac kupac);
	
	Kupac getById(int id);
	
	List<Kupac> findAll();
	
	void delete(int id);
}
