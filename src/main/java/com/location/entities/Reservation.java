package com.location.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idRes;

	@Column(name = "dateDebut")
	private Date dateDebut;
	@Column(name = "dateRtour")
	private Date dateRetour;
	@Column(name = "etatConfirmation")
	private boolean etatConfirmation;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Voiture voiture;

	@OneToMany(mappedBy = "commission")
	private List<Commision> commision;

	@ManyToOne
	@JoinColumn(name = "facture_id")
	private Facture facture;

	@ManyToOne
	@JoinColumn(name = "client")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "reclamation_id")
	private Reclamation reclamation;

}
