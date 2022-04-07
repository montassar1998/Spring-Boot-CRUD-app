package com.location.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.entities.Client;

@Repository
//this repo has the JPA repo and Clientrepocustom which has getClientByName
public interface ClientRepository extends JpaRepository<Client, Long>, ClientRepositoryCustom {

}
