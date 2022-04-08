package com.location.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.entities.Modele;
import com.location.repositories.ModeleRepository;

@Service
@Transactional
public class ModeleService {
	@Autowired
	private ModeleRepository repository;

	public List<Modele> listAll() {
		return repository.findAll();
	}

	public void save(Modele m) {
		repository.save(m);
	}

	public Modele get(long id) {
		return repository.findById(id).get();
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

}
