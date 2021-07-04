package com.example.projekat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
public class Fitnesscentar implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	@Column
	private String adresa;
	@Column
	private int brojtelefonacentrale;
	@Column(unique = true)
	private String email;

	boolean aktivan;


	public Fitnesscentar(Long id, String naziv, String adresa, int brojtelefonacentrale,String email) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojtelefonacentrale = brojtelefonacentrale;
		this.email = email;
		this.id = id;
	}

	public Fitnesscentar() {
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public int getBrojtelefonacentrale() {
		return brojtelefonacentrale;
	}

	public void setBrojtelefonacentrale(int brojtelefonacentrale) {
		this.brojtelefonacentrale = brojtelefonacentrale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	@JsonIgnore
	@OneToMany(mappedBy ="fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Trener>  trener =  new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy ="fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Sala>  sala =  new HashSet<>();


	@JsonIgnore
	@OneToMany(mappedBy ="fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Termin>  termin =  new HashSet<>();

	public Set<Trener> getTrener() {
		return trener;
	}

	public void setTrener(Set<Trener> trener) {
		this.trener = trener;
	}

	public Set<Sala> getSala() {
		return sala;
	}

	public void setSala(Set<Sala> sala) {
		this.sala = sala;
	}

	public Set<Termin> getTermin() {
		return termin;
	}

	public void setTermin(Set<Termin> termin) {
		this.termin = termin;
	}
}
