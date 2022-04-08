package com.location.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.location.entities.Voiture;
import com.location.service.VoitureService;

@Controller
public class VoitureControlller {
	@Autowired
	private VoitureService service;

// add_voiture
	@RequestMapping("/addvoiture")
	public String addVoiture(Model model) {
		Voiture voiture = new Voiture();
		model.addAttribute("voiture", voiture);
		return "new_voiture";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveVoiture(@ModelAttribute("voiture") Voiture voiture) {
		service.save(voiture);
		return "redirect:/";
	}

//liste_voiture

	@RequestMapping("/")
	public String listVoitures(Model model) {
		List<Voiture> listVoitures = service.listAll();

		model.addAttribute("listVoitures", listVoitures);

		return "liste_voitures";
	}

//update_voiture
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Voiture voiture = service.get(id);
		model.addAttribute("voiture", voiture);
		return "update-voiture";
	}

	@PostMapping("update/{id}")
	public String updateVoiture(@PathVariable("id") int id, @Valid Voiture voiture, BindingResult result, Model model) {
		if (result.hasErrors()) {
			voiture.setId(id);
			return "update-voiture";

		}
		service.save(voiture);
		model.addAttribute("voitures", service.listAll());
		return "liste-voitures";

	}
//delete_voiture

	@GetMapping("delete/{id}")
	public String deleteVoiture(@PathVariable("id") int id, Model model) {
		service.delete(id);
		model.addAttribute("voitures", service.listAll());
		return "liste-voitures";

	}

	// finished controller layer
}
