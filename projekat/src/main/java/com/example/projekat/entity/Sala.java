package com.example.projekat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Sala implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private int kapacitet;
	@Column
	private int oznaka;

	private boolean aktivan;




	public Sala(Long id, int kapacitet, int oznaka) {
		this.kapacitet = kapacitet;
		this.oznaka = oznaka;
		this.id = id;
	}

	public Sala() {
	}

    @JsonIgnore
	@OneToMany(mappedBy ="sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Termin> termini = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public int getOznaka() {
		return oznaka;
	}

	public void setOznaka(int oznaka) {
		this.oznaka = oznaka;
	}

	public Set<Termin> getTermini() {
		return termini;
	}

	public void setTermini(Set<Termin> termini) {
		this.termini = termini;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Fitnesscentar fitnesscentar;

	public Fitnesscentar getFitnesscentar() {
		return fitnesscentar;
	}

	public void setFitnesscentar(Fitnesscentar fitnesscentar) {
		this.fitnesscentar = fitnesscentar;
	}



}
