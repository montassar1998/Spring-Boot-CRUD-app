package com.location.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//model
@Entity
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "matricule")
	private String matricule;

	@Column(name = "date_mise_en_marche")
	private Date dateMiseEnMarche;
	@Column(name = "couleur")
	private String couleur;

	@Column(name = "etat")
	private String etat;
	@Column(name = "prixJour")
	private float prixJour;
	@OneToMany(mappedBy = "voiture")
	private List<Location> locations = new ArrayList<Location>();

	@ManyToOne
	@JoinColumn(name = "modele_id")
	private Modele modele;

	@OneToMany(mappedBy = "reservation")
	private List<Reservation> reservations;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "promotion", joinColumns = @JoinColumn(name = "column_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "voiture_id", referencedColumnName = "id"))
	private List<Promotion> promotions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public float getPrixJour() {
		return prixJour;
	}

	public void setPrixJour(float prixJour) {
		this.prixJour = prixJour;
	}

	public Date getDateMiseEnMarche() {
		return dateMiseEnMarche;
	}

	public void setDateMiseEnMarche(Date dateMiseEnMarche) {
		this.dateMiseEnMarche = dateMiseEnMarche;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Voiture() {

	}
}
