package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Artikal;
import com.example.demo.repository.ArtikalRepository;

@Service
@Transactional
public class ArtikalServiceImpl implements ArtikalService {
	
	@Autowired
	private ArtikalRepository artikalRepository;

	@Override
	public void save(Artikal artikal) {
		artikalRepository.save(artikal);
	}

	@Override
	public Artikal getById(int id) {
		return artikalRepository.getById(id);
	}

	@Override
	public List<Artikal> findAll() {
		return artikalRepository.findAll();
	}

	@Override
	public void delete(int id) {
		artikalRepository.deleteById(id);
	}
}
