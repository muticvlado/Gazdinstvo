package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Stavka;
import com.example.demo.repository.StavkaRepository;

@Service
@Transactional
public class StavkaServiceImpl implements StavkaService {

	@Autowired
	private StavkaRepository stavkaRepository;
	
	@Override
	public void save(Stavka stavka) {
		stavkaRepository.save(stavka);		
	}

	@Override
	public Stavka getById(int id) {
		return stavkaRepository.getById(id);
	}

	@Override
	public List<Stavka> findAll() {
		return stavkaRepository.findAll();
	}

	@Override
	public void delete(int id) {
		stavkaRepository.deleteById(id);
	}
}
