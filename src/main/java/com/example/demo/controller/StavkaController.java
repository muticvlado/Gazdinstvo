package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Artikal;
import com.example.demo.model.Racun;
import com.example.demo.model.Stavka;
import com.example.demo.service.ArtikalService;
import com.example.demo.service.RacunService;
import com.example.demo.service.StavkaService;

@Controller
public class StavkaController {
	
	@Autowired
	private StavkaService stavkaService;
	
	@Autowired
	private RacunService racunService;
	
	@Autowired
	private ArtikalService artikalService;
	
	@RequestMapping("/stavka-new")
	public String getStavkaForm(@RequestParam int racunid, Model model) {
		Racun racun = racunService.getById(racunid);
		Stavka stavka = new Stavka();
		stavka.setRacun(racun);
		model.addAttribute("stavka", stavka);
		model.addAttribute("artikli", artikalService.findAll());
		return "stavka-form";
	}
	
	@RequestMapping("/stavka-save")
	public String saveStavka(@ModelAttribute Stavka stavka) {
		Artikal artikal = artikalService.getById(stavka.getArtikal().getId());
		Racun racun = racunService.getById(stavka.getRacun().getId());
		stavka.setRacun(racun);
		stavka.setArtikal(artikal);
		stavkaService.save(stavka);
		return "redirect:/old-racun-form?id=" + stavka.getRacun().getId();
	}
	
	@RequestMapping("/stavka-delete")
	public String deleteStavka(@RequestParam int stavkaid, @RequestParam int racunid) {		
		stavkaService.delete(stavkaid);
		return "redirect:/old-racun-form?id=" + racunid;		
	}
	
	@RequestMapping("/stavka-edit")
	public String editStavka(@RequestParam int id, Model model) {	
		Stavka stavka = stavkaService.getById(id);
		model.addAttribute("stavka", stavka);
		model.addAttribute("artikli", artikalService.findAll());
		return "stavka-form";		
	}	
}
