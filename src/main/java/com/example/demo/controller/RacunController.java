package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Racun;
import com.example.demo.service.KupacService;
import com.example.demo.service.RacunService;

@Controller
public class RacunController {
	
	@Autowired
	private RacunService racunService;
	
	@Autowired
	private KupacService kupacService;
	
	@RequestMapping("/index")
	public String getIndex() {	
		return "index";
	}
		
	@RequestMapping("/new-racun-form")
	public String getRacunForm(Model model) {	
		model.addAttribute("racun", new Racun());
		model.addAttribute("kupci", kupacService.findAll());
		return "racun-form";
	}
	
	@RequestMapping("/old-racun-form")
	public String getRacunForm(@RequestParam int id, Model model) {
		Racun racun = racunService.getById(id);
		model.addAttribute("racun", racun);
		model.addAttribute("kupci", kupacService.findAll());
		return "racun-form";
	}
	
	@RequestMapping("/racun-save")	
	public String saveRacun(@ModelAttribute Racun racun) {
		racunService.save(racun);
		return "redirect:/old-racun-form?id=" + racun.getId();
	}
	
	@RequestMapping("/racun-list")
	public String getRacunList(Model model) {
		model.addAttribute("racuni", racunService.findAll());		
		return "racun-list";
	}
	
	@RequestMapping("/racun-edit")	
	public String getRacunEdit(@RequestParam int id) {		
		return "redirect:/old-racun-form?id=" + id;
	}
}
