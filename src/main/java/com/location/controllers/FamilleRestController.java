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

import com.location.entities.Famille;
import com.location.service.FamilleService;

//import antlr.collections.List;

@Controller
public class FamilleRestController {

	@Autowired
	private FamilleService service;

	@GetMapping("/familles")
	public ResponseEntity<List<Famille>> getAllFamilles() {
		try {
			List<com.location.entities.Famille> familles = service.listAll();
			if (familles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/familles/{id}")
	public ResponseEntity<Famille> getFamilleById(@PathVariable("id") int id) {
		Famille famille = service.get(id);
		if (famille != null) {
			return new ResponseEntity<>(famille, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addFamille")
	public ResponseEntity<Famille> createFamille(@RequestBody Famille famille) {
		try {
			service.save(famille);
			return new ResponseEntity<>(famille, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/familles/{id}")
	public ResponseEntity<Famille> updateFamille(@PathVariable("id") int id, @RequestBody Famille famille) {

		Famille _famille = service.get(id);
		if (_famille != null) {
			Famille newfamille = _famille;
			newfamille.setDescription(_famille.getDescription());

			service.save(newfamille);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/familles/{id}")
	public ResponseEntity<HttpStatus> deleteFamille(@PathVariable("id") int id) {
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/familles")
	public ResponseEntity<HttpStatus> deleteAllFamilles() {
		try {
			service.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
