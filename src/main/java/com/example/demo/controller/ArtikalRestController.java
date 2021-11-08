package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ArtikalService;

@RestController
public class ArtikalRestController {
	
	@Autowired
	private ArtikalService artikalService;
	
	@RequestMapping("/get-artikal/{id}")
	public int getArtikal(@PathVariable int id) {
		return (int) artikalService.getById(id).getCena();
	}

}
