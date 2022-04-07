package com.location.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;
	@Enumerated(EnumType.STRING)
	// @Column(name = "role")
	private Role role;

}
