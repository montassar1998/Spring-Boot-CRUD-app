package com.location.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ModePaiement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idModePaiement;

	@Column(name = "descModePaiement")
	private DescModePaiement descModePaiement;

	@OneToMany(mappedBy = "id_reservation")
	private List<Reservation> reservations;
}
