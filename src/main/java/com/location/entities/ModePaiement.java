package com.location.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Modepaiement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "descModePaiement")
	private DescModePaiement descModePaiement;

	@OneToMany(mappedBy = "modepaiement")
	private List<Reservation> reservations;
}
