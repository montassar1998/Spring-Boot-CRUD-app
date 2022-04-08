package com.location.repositories;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.location.entities.Client;
import com.location.entities.Reservation;
import com.location.entities.Voiture;

@Repository
@Transactional
public class ReservationRepositoryImpl implements ReservationRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;

	public Reservation ListeReservationByClient(Client client) {
		Query query = (Query) entityManager.createNativeQuery("SELECT c.* FROM Client c " + " WHERE c.name LIKE ? ",
				Client.class);
		((javax.persistence.Query) query).setParameter(1, client + "%");
		return (Reservation) ((javax.persistence.Query) query).getSingleResult();
	}

	public Reservation listeReservationByVoiture(Voiture voiture) {
		Query query = (Query) entityManager.createNativeQuery("SELECT c.* FROM voiture v " + " WHERE v.name LIKE ? ",
				Voiture.class);
		((javax.persistence.Query) query).setParameter(1, voiture + "%");
		return (Reservation) ((javax.persistence.Query) query).getSingleResult();

	}

}
