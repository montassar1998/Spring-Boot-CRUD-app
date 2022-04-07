package com.location.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ModePaiement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idModePaiement;

	@Column(name = "descModePaiement")
	private DescModePaiement descModePaiement;
}
