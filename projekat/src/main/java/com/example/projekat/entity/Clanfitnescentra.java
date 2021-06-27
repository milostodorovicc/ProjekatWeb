package com.example.projekat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
public class Clanfitnescentra implements Serializable    {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique= true)
	private String korisnickoime;
	@Column(unique = true)
	private String lozinka;
	@Column
	private String ime;
	@Column
	private String prezime;
	@Column
	private int telefon;
	@Column(unique = true)
	private String email;
	@Column
	private Date datumrodjenja;
	@Enumerated(EnumType.STRING)
	private Uloga uloga;

	public String getKorisnickoime() {
		return korisnickoime;
	}
	public void setKorisnickoime(String korisnickoime) {
		this.korisnickoime = korisnickoime;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public int getTelefon() {
		return telefon;
	}
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDatumrodjenja() {
		return datumrodjenja;
	}
	public void setDatumrodjenja(Date datumrodjenja) {
		this.datumrodjenja = datumrodjenja;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Clanfitnescentra() {
	}

	@ManyToMany
	@JoinTable(name = "odradjentrening",
			joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
	private Set<Termin> termin = new HashSet<>();


	@ManyToMany
	@JoinTable(name = "rezervisantrening",
			joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))

	private Set<Termin> termin1 = new HashSet<>();


	public Set<Termin> getTermin() {
		return termin;
	}

	public void setTermin(Set<Termin> termin) {
		this.termin = termin;
	}

	public void addnewtermin(Termin termin){this.termin1.add(termin);}


	public Set<Termin> getTermin1() {
		return termin1;
	}

	public void setTermin1(Set<Termin> termin1) {
		this.termin1 = termin1;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}


	@OneToMany(mappedBy ="clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Ocenjentrening>  ocenjentrening =  new HashSet<>();



}
