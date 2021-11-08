package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Artikal;
import com.example.demo.service.ArtikalService;

@Controller
public class ArtikalController {
	
	@Autowired
	private ArtikalService artikalService;
	
	@RequestMapping("/artikal-form")
	public String getArtikalForm(Model model) {
		model.addAttribute("artikal", new Artikal());
		return "artikal-form";
	}
	
	@RequestMapping("/artikal-save")
	public String saveArtikal(@ModelAttribute Artikal artikal) {
		artikalService.save(artikal);
		return "redirect:/artikal-list";
	}
	
	@RequestMapping("/artikal-edit")
	public String getEditArtikal(@RequestParam int id, Model model) {
		model.addAttribute("artikal", artikalService.getById(id));
		return "artikal-form";
	}
	
	@RequestMapping("/artikal-list")	
	public String getArtikalList(Model model) {
		model.addAttribute("artikli", artikalService.findAll());
		return "artikal-list";
	}
	
	@RequestMapping("/artikal-delete")
	public String deleteArtikal(@RequestParam int id) {
		artikalService.delete(id);
		return "redirect:/artikal-list";
	}
}
