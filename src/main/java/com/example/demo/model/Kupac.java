package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Kupac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String naziv;
	@Column
	private String adresa;
	@Column
	private String mesto;
	@Column
	private String pib;
	@Column
	private String telefon;
	@Column
	private String email;
	
	@OneToMany(mappedBy = "kupac", cascade = CascadeType.ALL)
	private List<Racun> racuni;

	public Kupac() {		
	}

	public Kupac(String naziv, String adresa, String mesto, String pib, String telefon, String email, List<Racun> racuni) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.mesto = mesto;
		this.pib = pib;
		this.telefon = telefon;
		this.email = email;
		this.racuni = racuni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}	
}
