package com.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.location.entities.Modele;
import com.location.service.ModeleService;

//import antlr.collections.List;

@Controller
public class ModeleRestController {

	@Autowired
	private ModeleService service;

	@GetMapping("/modeles")
	public ResponseEntity<List<Modele>> getAllModeles() {
		try {
			List<com.location.entities.Modele> modeles = service.listAll();
			if (modeles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/modeles/{id}")
	public ResponseEntity<Modele> getModeleById(@PathVariable("id") int id) {
		Modele modele = service.get(id);
		if (modele != null) {
			return new ResponseEntity<>(modele, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addModele")
	public ResponseEntity<Modele> createModele(@RequestBody Modele modele) {
		try {
			service.save(modele);
			return new ResponseEntity<>(modele, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modeles/{id}")
	public ResponseEntity<Modele> updateModele(@PathVariable("id") int id, @RequestBody Modele modele) {

		Modele _modele = service.get(id);
		if (_modele != null) {
			Modele newmodele = _modele;
			newmodele.setMarque(_modele.getMarque());

			service.save(newmodele);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/modeles/{id}")
	public ResponseEntity<HttpStatus> deleteModele(@PathVariable("id") int id) {
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/modeles")
	public ResponseEntity<HttpStatus> deleteAllModeles() {
		try {
			service.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
