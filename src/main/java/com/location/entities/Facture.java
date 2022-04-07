package com.location.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFact;

	@Column(name = "prixTotal")
	private float prixTotal;

	@OneToMany(mappedBy = "reservation")
	private List<Reservation> reservations;

}
