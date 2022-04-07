package com.location.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Motif {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "libelle")
	private String libelle;

	@OneToMany(mappedBy = "motif")
	private List<Reclamation> reclamations;

	@OneToMany(mappedBy = "motif")
	private List<Message> messages;
}
