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

import com.location.entities.Voiture;
import com.location.service.VoitureService;

//import antlr.collections.List;

@Controller
public class VoitureRestController {

	@Autowired
	private VoitureService service;

	@GetMapping("/voitures")
	public ResponseEntity<List<Voiture>> getAllVoitures() {
		try {
			List<com.location.entities.Voiture> voitures = service.listAll();
			if (voitures.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/voitures/{id}")
	public ResponseEntity<Voiture> getVoitureById(@PathVariable("id") int id) {
		Voiture voiture = service.get(id);
		if (voiture != null) {
			return new ResponseEntity<>(voiture, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addVoiture")
	public ResponseEntity<Voiture> createVoiture(@RequestBody Voiture voiture) {
		try {
			service.save(voiture);
			return new ResponseEntity<>(voiture, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/voitures/{id}")
	public ResponseEntity<Voiture> updateVoiture(@PathVariable("id") int id, @RequestBody Voiture voiture) {

		Voiture _voiture = service.get(id);
		if (_voiture != null) {
			Voiture newvoiture = _voiture;
			newvoiture.setMatricule(_voiture.getMatricule());
			newvoiture.setDateMiseEnMarche(_voiture.getDateMiseEnMarche());
			service.save(newvoiture);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/voitures/{id}")
	public ResponseEntity<HttpStatus> deleteVoiture(@PathVariable("id") int id) {
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/voitures")
	public ResponseEntity<HttpStatus> deleteAllVoitures() {
		try {
			service.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
