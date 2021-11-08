package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Kupac;
import com.example.demo.model.Racun;
import com.example.demo.repository.RacunRepository;

@Service
@Transactional
public class RacunServiceImpl implements RacunService {
	
	@Autowired
	private RacunRepository racunRepository;
	
	@Autowired
	private KupacService kupacService;

	@Override
	public void save(Racun racun) {		//ovaj racun ima samo kupac_id vrednost, a potreban nam je ceo objekat kupac
		Kupac k = kupacService.getById(racun.getKupac().getId());
		racun.setKupac(k);
		racunRepository.save(racun);
	}

	@Override
	public Racun getById(int id) {
		Racun racun = racunRepository.getById(id);
		Hibernate.initialize(racun.getStavke());
		return racun;
	}

	@Override
	public List<Racun> findAll() {
		return racunRepository.findAll();
	}

	@Override
	public void delete(int id) {
		racunRepository.deleteById(id);
	}
}
