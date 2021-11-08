package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Kupac;
import com.example.demo.service.KupacService;

@Controller
public class KupacController {
	
	@Autowired
	private KupacService kupacService;
	
	@RequestMapping("/kupac-form")
	public String getKupacForm(Model model) {
		model.addAttribute("kupac", new Kupac());
		return "kupac-form";
	}
	
	@RequestMapping("/kupac-save")
	public String saveKupac(@ModelAttribute Kupac kupac) {
		kupacService.save(kupac);
		return "redirect:/kupac-list";
	}
	
	@RequestMapping("/kupac-edit")
	public String getEditKupac(@RequestParam int id, Model model) {
		model.addAttribute("kupac", kupacService.getById(id));
		return "kupac-form";
	}
	
	@RequestMapping("/kupac-list")
	public String getKupacList(Model model) {
		model.addAttribute("kupci", kupacService.findAll());
		return "kupac-list";
	}
	
	@RequestMapping("/kupac-delete")
	public String deleteKupac(@RequestParam int id) {
		kupacService.delete(id);
		return "redirect:/kupac-list";
	}
}
