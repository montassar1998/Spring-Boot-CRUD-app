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
	private long idMotif;

	@Column(name = "libelle")
	private String libelle;

	@OneToMany(mappedBy = "id_reclamation")
	private List<Reclamation> reclamations;

	@OneToMany(mappedBy = "id_message")
	private List<Message> messages;
}
