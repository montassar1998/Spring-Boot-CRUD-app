package com.location.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Famille {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idFamille;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "Famille")
	private List<Modele> modeles;
}
