package com.location.entities;

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
public class Modele {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "marque")
	private String marque;

	@ManyToOne
	@JoinColumn(name = "famille_id")
	private Famille famille;

	@OneToMany(mappedBy = "modele")
	private List<Voiture> voitures;
}
