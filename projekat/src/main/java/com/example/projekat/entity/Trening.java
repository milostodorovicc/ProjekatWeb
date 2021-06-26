package com.example.projekat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trening implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String naziv;
	@Column
	private String opis;
	@Column
	private String tip;
	@Column
	private Double trajanje;

	@JsonIgnore
	@OneToMany(mappedBy ="trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Termin> termini = new HashSet<>();





	public Trening(Long id,String naziv, String opis, String tip, Double trajanje) {
		this.naziv = naziv;
		this.opis = opis;
		this.tip = tip;
		this.trajanje = trajanje;
		this.id = id;
	}

	public Trening() {
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Double getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(Double trajanje) {
		this.trajanje = trajanje;
	}

	public Set<Termin> getTermini() {
		return termini;
	}

	public void setTermini(Set<Termin> termini) {
		this.termini = termini;
	}





}
