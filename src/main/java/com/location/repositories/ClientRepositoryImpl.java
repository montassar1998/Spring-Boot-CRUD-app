package com.location.repositories;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.location.entities.Client;

@Repository
@Transactional
public class ClientRepositoryImpl implements ClientRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;

	public Client getClientByName(String name) {
		Query query = (Query) entityManager.createNativeQuery("SELECT c.* FROM Client c " + " WHERE c.name LIKE ? ",
				Client.class);
		((javax.persistence.Query) query).setParameter(1, name + "%");
		return (Client) ((javax.persistence.Query) query).getSingleResult();
	}
}
