package com.location.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
