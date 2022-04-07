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
public class Reclamation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "details")
	private String details;

	@Column(name = "dateRec")
	private Date dateRec;

	@OneToMany(mappedBy = "reclamation")
	private List<Reservation> reservations;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "motif_id")
	private Motif motif;

	@ManyToOne
	@JoinColumn(name = "id_mode_paiement")
	private Modepaiement modePaiements;

}
