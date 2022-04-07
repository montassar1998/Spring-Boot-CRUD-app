package com.location.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.entities.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long>, VoitureRepositoryCustom {

}
