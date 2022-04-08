package com.location.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.entities.Reservation;

@Repository
@Transactional
public interface ReservationRepository extends JpaRepository<Reservation, Long>, ReservationRepositoryCustom {

}
