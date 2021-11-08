package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Racun;

public interface RacunRepository extends JpaRepository<Racun, Integer>, RacunRepositoryCustom {

}
