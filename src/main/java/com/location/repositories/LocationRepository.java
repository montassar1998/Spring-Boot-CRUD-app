package com.location.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.entities.Location;
@Repository
@Transactional
public interface LocationRepository extends JpaRepository<Location, Long>, LocationRepositoryCustom {

}
