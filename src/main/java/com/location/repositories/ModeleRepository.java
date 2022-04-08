package com.location.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.entities.Modele;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, Long>, ModeleRepositoryCustom {

}
