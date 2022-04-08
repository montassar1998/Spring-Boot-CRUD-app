package com.location.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.location.entities.Modele;

@Repository
@Transactional
public class ModeleRepositoryImpl implements ModeleRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;

	public Modele getModeleByFamille(String family) {
		return null;
	}

	public Modele getAllModels() {

		return null;
	}

}
