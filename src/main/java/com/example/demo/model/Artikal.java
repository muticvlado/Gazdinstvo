package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Artikal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String naziv;
	@Column
	private String jm;
	@Column
	private double porez;
	@Column
	private double cena;
	
	public Artikal() {
	}

	public Artikal(String naziv, String jm, double porez, double cena) {
		this.naziv = naziv;
		this.jm = jm;
		this.porez = porez;
		this.cena = cena;
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

	public String getJm() {
		return jm;
	}

	public void setJm(String jm) {
		this.jm = jm;
	}

	public double getPorez() {
		return porez;
	}

	public void setPorez(double porez) {
		this.porez = porez;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}	
}
