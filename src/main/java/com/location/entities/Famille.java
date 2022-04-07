package com.location.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Famille {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idFamille;

	@Column(name = "description")
	private String description;

}
