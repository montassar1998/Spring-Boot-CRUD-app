package com.location.repositories;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.location.entities.Voiture;

@Repository
@Transactional
public class VoitureRepositoryImpl implements VoitureRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;

	public Voiture ListeVoitureByModel(String model) {
		Query query = (Query) entityManager.createNativeQuery("SELECT c.* FROM Voiture c " + " WHERE c.model LIKE ? ",
				Voiture.class);
		((javax.persistence.Query) query).setParameter(1, model + "%");
		return (Voiture) ((javax.persistence.Query) query).getSingleResult();
	}

}
