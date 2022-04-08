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

import com.location.entities.Modele;
import com.location.service.ModeleService;

@Controller
public class ModeleController {

	@Autowired
	private ModeleService service;

	// add_Modele
	@RequestMapping("/addModele")
	public String addModele(Model model) {
		Modele modele = new Modele();
		model.addAttribute("Modele", modele);
		return "new_Modele";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveModele(@ModelAttribute("Modele") Modele modele) {
		service.save(modele);
		return "redirect:/";
	}

	// liste_Modele

	@RequestMapping("/")
	public String listModeles(Model model) {
		List<Modele> listModeles = service.listAll();

		model.addAttribute("listModeles", listModeles);

		return "liste_Modeles";
	}

	// update_Modele
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Modele modele = service.get(id);
		model.addAttribute("modele", modele);
		return "update-Modele";
	}

	@PostMapping("update/{id}")
	public String updateModele(@PathVariable("id") int id, @Valid Modele modele, BindingResult result, Model model) {
		if (result.hasErrors()) {
			modele.setId(id);
			return "update-Modele";

		}
		service.save(modele);
		model.addAttribute("Modeles", service.listAll());
		return "liste-Modeles";

	}
	// delete_Modele

	@GetMapping("delete/{id}")
	public String deleteModele(@PathVariable("id") int id, Model model) {
		service.delete(id);
		model.addAttribute("Modeles", service.listAll());
		return "liste-Modeles";

	}
}
