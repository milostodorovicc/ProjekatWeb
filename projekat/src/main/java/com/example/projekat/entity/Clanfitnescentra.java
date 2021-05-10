package com.example.projekat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
public class Clanfitnescentra    {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique= true)
	private String korisnickoime;
	@Column
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
//	public String getUloga() {
//		return uloga;
//	}
//	public void setUloga(String uloga) {
//		this.uloga = uloga;
//	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Clanfitnescentra() {
	}

    @ManyToMany(mappedBy = "clan")
	private Set<Termin> odradjenitermini = new HashSet<>();

	@ManyToMany(mappedBy = "clan1")
	private Set<Termin> rezervisanitermini = new HashSet<>();

	public Set<Termin> getOdradjenitermini() {
		return odradjenitermini;
	}

	public void setOdradjenitermini(Set<Termin> odradjenitermini) {
		this.odradjenitermini = odradjenitermini;
	}

	public Set<Termin> getRezervisanitermini() {
		return rezervisanitermini;
	}

	public void setRezervisanitermini(Set<Termin> rezervisanitermini) {
		this.rezervisanitermini = rezervisanitermini;
	}
//public Set<Termin> getTermini() {
	//	return termini;
	//}

//	public void setTermini(Set<Termin> termini) {
//		this.termini = termini;
//	}

//	public Set<Termin> getTermini1() {
//		return termini1;
//	}

//	public void setTermini1(Set<Termin> termini1) {
//		this.termini1 = termini1;
//	}


	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
}
