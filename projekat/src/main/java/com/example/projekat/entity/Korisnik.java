package com.example.projekat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;



public  class Korisnik  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String korisnickoime;
	@Column
	private String lozinka;
	@Column
	private String ime;
	@Column
	private String prezime;
	@Column
	private int telefon;
	@Column
	private String email;
	@Column
	private int datumrodjenja;
	@Column
	private String uloga;
	
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
	public int getDatumrodjenja() {
		return datumrodjenja;
	}
	public void setDatumrodjenja(int datumrodjenja) {
		this.datumrodjenja = datumrodjenja;
	}
	public String getUloga() {
		return uloga;
	}
	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	@Override
	public String toString() {
		return "Korisnik [ korisnickoime=" + korisnickoime + ", lozinka=" + lozinka + ", ime=" + ime
				+ ", prezime=" + prezime + ", telefon=" + telefon + ", email=" + email + ", datumrodjenja="
				+ datumrodjenja + ", uloga=" + uloga + "]";
	}
	public Korisnik( String korisnickoime, String lozinka, String ime, String prezime, int telefon,
			String email, int datumrodjenja, String uloga) {


		this.korisnickoime = korisnickoime;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
		this.datumrodjenja = datumrodjenja;
		this.uloga = uloga;
	}
	public Korisnik() {

	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
