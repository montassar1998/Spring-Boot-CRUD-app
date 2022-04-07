package com.location.repositories;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.location.entities.Client;
import com.location.entities.Location;
import com.location.entities.Voiture;

@Repository
@Transactional
public class LocationRepositoryImpl implements LocationRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;

	public Location ListeLocationByClient(Client client) {
		Query query = (Query) entityManager.createNativeQuery("SELECT c.* FROM Client c " + " WHERE c.name LIKE ? ",
				Client.class);
		((javax.persistence.Query) query).setParameter(1, client + "%");
		return (Location) ((javax.persistence.Query) query).getSingleResult();
	}

	public Location listeLocationByVoiture(Voiture voiture) {
		Query query = (Query) entityManager.createNativeQuery("SELECT c.* FROM voiture v " + " WHERE v.name LIKE ? ",
				Voiture.class);
		((javax.persistence.Query) query).setParameter(1, voiture + "%");
		return (Location) ((javax.persistence.Query) query).getSingleResult();

	}

}
