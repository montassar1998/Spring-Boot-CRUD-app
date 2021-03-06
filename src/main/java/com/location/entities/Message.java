package com.location.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "sentby")
	private String sentby;
	@Column(name = "sentto")
	private String sentto;
	@Column(name = "dateEnvoi")
	private Date dateEnvoi;
	@Column(name = "msg")
	private String msg;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "gestionnaire_id")
	private Gestionnaire gestionnaire;

	@ManyToOne
	@JoinColumn(name = "motif_id")
	private Motif motif;
}
