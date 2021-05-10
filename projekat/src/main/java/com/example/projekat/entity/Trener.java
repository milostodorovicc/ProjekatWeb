package com.example.projekat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Trener   {

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
	private Date datumrodjenja;
	@Enumerated(EnumType.STRING)
	private Uloga uloga;
	@Column
	private double prosecnaocena;

	public double getProsecnaocena() {
		return prosecnaocena;
	}

	public void setProsecnaocena(double prosecnaocena) {
		this.prosecnaocena = prosecnaocena;
	}

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


	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public Fitnesscentar getFitnesscentar() {
		return fitnesscentar;
	}

	public void setFitnesscentar(Fitnesscentar fitnesscentar) {
		this.fitnesscentar = fitnesscentar;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	//@OneToOne
	//@JoinColumn(name = "trening_ID")
	//private Trening treninzi;
	//@JoinTable(name ="trening",
	         // joinColumns = @JoinColumn(name = "trener_id",referencedColumnName = "id"),
	         // inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
	//private Set<Trening> treninzi = new HashSet<>();


	//public Trener(String korisnickoime, String lozinka, String ime, String prezime, int telefon, String email, int datumrodjenja, String uloga) {
	//	super(korisnickoime, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga);
	//	this.id = id;
	//}


	public Trener(Long id, String korisnickoime, String lozinka, String ime, String prezime, int telefon, String email, Date datumrodjenja, Uloga uloga, double prosecnaocena) {
		this.id = id;
		this.korisnickoime = korisnickoime;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
		this.datumrodjenja = datumrodjenja;
		this.uloga = uloga;
		this.prosecnaocena = prosecnaocena;
	}

	public Trener() {
	}

	//@ManyToOne(fetch = FetchType.EAGER)
	//private Termin termin;



	//@OneToMany(mappedBy ="trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	//private Set <Fitnesscentar>  fitnesscentar =  new HashSet<>();

	//public Termin getTermin() {
	//	return termin;
	//}

	//public void setTermin(Termin termin) {
	//	this.termin = termin;
	//}

	//public Set<Fitnesscentar> getFitnesscentar() {
	//	return fitnesscentar;
	//}

	//public void setFitnesscentar(Set<Fitnesscentar> fitnesscentar) {
	//	this.fitnesscentar = fitnesscentar;
	//}

	//@ManyToMany
	//@JoinTable(name = "Treninzikojedrzitrener",
	//		joinColumns = @JoinColumn(name = "trener_id", referencedColumnName = "id"),
	//		inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
	//private Set<Termin> termin = new HashSet<>();

	public Set<Termin> getTermin() {
		return termin;
	}

	public void setTermin(Set<Termin> termin) {
		this.termin = termin;
	}

	//@ManyToMany(mappedBy = "trener")
	//private Set<Fitnesscentar> fitnesscentar = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Fitnesscentar fitnesscentar;


	@OneToMany(mappedBy ="trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Termin>  termin =  new HashSet<>();

}
