package com.location.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.entities.Famille;

@Repository
public interface FamilleRepository extends JpaRepository<Famille, Long>, FamilleRepositoryCustom {

}
