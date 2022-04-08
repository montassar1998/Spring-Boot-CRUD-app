package com.location.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.entities.Famille;
import com.location.repositories.FamilleRepository;

@Service
@Transactional
public class FamilleService {
	@Autowired
	private FamilleRepository family;

	public List<Famille> listAll() {
		return family.findAll();
	}

	public void save(Famille famille) {
		family.save(famille);
	}

	public Famille get(long id) {
		return family.findById(id).get();
	}

	public void delete(long id) {
		family.deleteById(id);
	}

	public void deleteAll() {
		family.deleteAll();

	}
}
