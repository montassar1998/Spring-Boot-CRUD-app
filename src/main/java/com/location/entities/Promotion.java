package com.location.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPromotion;

	@Column(name = "dateD")
	private Date dateD;

	@Column(name = "dateF")
	private Date DateF;

	@Column(name = "pourcentage")
	private float pourcentage;

	@ManyToMany(mappedBy = "voitures")
	private List<Voiture> voitures;
}
