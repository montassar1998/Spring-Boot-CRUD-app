package com.location.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reclamation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idRec;

	@Column(name = "details")
	private String details;

	@Column(name = "dateRec")
	private Date dateRec;

}
