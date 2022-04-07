package com.location.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gestionnaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "cin")
	private Integer cin;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "adresse")
	private String adresse;
	@Column(name = "numTel")
	private String numTel;

	@OneToMany(mappedBy = "id_commission")
	private List<Commision> commisions;

	@OneToMany(mappedBy = "id_message")
	private List<Message> messages;
}
