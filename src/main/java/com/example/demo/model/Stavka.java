package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Stavka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private double porez;
	@Column
	private double kolicina;
	@Column
	private double cena;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "racun_id")
	private Racun racun;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "artikal_id")
	private Artikal artikal;

	public Stavka() {
	}

	public Stavka(double porez, double kolicina, double cena, Racun racun, Artikal artikal) {
		this.porez = porez;
		this.kolicina = kolicina;
		this.cena = cena;
		this.racun = racun;
		this.artikal = artikal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPorez() {
		return porez;
	}

	public void setPorez(double porez) {
		this.porez = porez;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}	
}
