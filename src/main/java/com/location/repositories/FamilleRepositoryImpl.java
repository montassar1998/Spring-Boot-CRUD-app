package com.location.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class FamilleRepositoryImpl {
	@PersistenceContext
	EntityManager entityManager;
}
