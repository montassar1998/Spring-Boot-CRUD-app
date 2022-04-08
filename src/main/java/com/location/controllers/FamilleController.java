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

import com.location.entities.Famille;
import com.location.service.FamilleService;

@Controller
public class FamilleController {
	@Autowired
	private FamilleService service;

	// add_famille
	@RequestMapping("/addFamille")
	public String addfamille(Model model) {
		Famille famille = new Famille();
		model.addAttribute("famille", famille);
		return "new_famille";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savefamille(@ModelAttribute("famille") Famille famille) {
		service.save(famille);
		return "redirect:/";
	}

	// liste_famille

	@RequestMapping("/")
	public String listfamilles(Model model) {
		List<Famille> listfamilles = service.listAll();

		model.addAttribute("listfamilles", listfamilles);

		return "liste_familles";
	}

	// update_famille
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Famille famille = service.get(id);
		model.addAttribute("famille", famille);
		return "update-famille";
	}

	@PostMapping("update/{id}")
	public String updatefamille(@PathVariable("id") int id, @Valid Famille famille, BindingResult result, Model model) {
		if (result.hasErrors()) {
			famille.setId(id);
			return "update-famille";

		}
		service.save(famille);
		model.addAttribute("familles", service.listAll());
		return "liste-familles";

	}
	// delete_famille

	@GetMapping("delete/{id}")
	public String deletefamille(@PathVariable("id") int id, Model model) {
		service.delete(id);
		model.addAttribute("familles", service.listAll());
		return "liste-familles";

	}
}
