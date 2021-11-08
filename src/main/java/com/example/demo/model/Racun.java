package com.example.demo.model;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Racun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column	
	private int id;
	@Column
	private int broj;
	@Column
	@Temporal(TemporalType.DATE)
	private Date datum;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "kupac_id")
	private Kupac kupac;
	
	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "racun")
	private List<Stavka> stavke;
	
	public Racun() {
	}

	public Racun(int broj, Date date, Kupac kupac, List<Stavka> stavke) {
		this.broj = broj;
		this.datum = date;
		this.kupac = kupac;
		this.stavke = stavke;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date date) {
		this.datum = date;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public List<Stavka> getStavke() {
		return stavke;
	}

	public void setStavke(List<Stavka> stavke) {
		this.stavke = stavke;
	}
}
