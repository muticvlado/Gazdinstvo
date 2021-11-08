package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Kupac;
import com.example.demo.repository.KupacRepository;

@Service
@Transactional
public class KupacServiceImpl implements KupacService {

	@Autowired
	private KupacRepository kupacRepository;
	
	@Override
	public void save(Kupac kupac) {
		kupacRepository.save(kupac);
	}

	@Override
	public Kupac getById(int id) {
		return kupacRepository.getById(id);
	}

	@Override
	public List<Kupac> findAll() {
		return kupacRepository.findAll();
	}

	@Override
	public void delete(int id) {
		kupacRepository.deleteById(id);		
	}
}
