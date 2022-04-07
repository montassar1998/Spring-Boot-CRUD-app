package com.location.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Motif {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMotif;

	@Column(name = "libelle")
	private String libelle;

}
