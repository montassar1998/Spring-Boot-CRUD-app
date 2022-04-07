package com.location.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commision {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idComm;

	@Column(name = "dateC")
	private Date dateC;

	@Column(name = "percent")
	private float percent;
}
