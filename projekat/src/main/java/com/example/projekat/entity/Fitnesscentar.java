package com.example.projekat.entity;

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
	@Column
	private String email;
	//@Column
	//private List<Trener> treneriuovomfitcentru;
	//@Column
	//private List<Sala> saleuovomfitnescentru;

	//@OneToMany(mappedBy ="sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	//private Set<Sala> sale = new HashSet<>();

	public Fitnesscentar(Long id, String naziv, String adresa, int brojtelefonacentrale,String email) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojtelefonacentrale = brojtelefonacentrale;
		this.email = email;
		this.id = id;
	}

	public Fitnesscentar() {
	}



	//@ManyToOne(fetch = FetchType.EAGER)
	//private Trener trener;

	//@ManyToOne(fetch = FetchType.EAGER)
	//private Sala sala;

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


	//@ManyToMany
	//@JoinTable(name = "Trenerikojiradeufitnesscentru",
	//		joinColumns = @JoinColumn(name = "fitnesscentar_id", referencedColumnName = "id"),
	//		inverseJoinColumns = @JoinColumn(name = "trener_id", referencedColumnName = "id"))
	//private Set<Trener> trener = new HashSet<>();


	//@ManyToMany
	//@JoinTable(name = "Listasalakojesenalazeufitnesscentru",
	//		joinColumns = @JoinColumn(name = "fitnesscentar_id", referencedColumnName = "id"),
	//		inverseJoinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"))
	//private Set<Sala> sala = new HashSet<>();

	@OneToMany(mappedBy ="fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Trener>  trener =  new HashSet<>();

	@OneToMany(mappedBy ="fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Sala>  sala =  new HashSet<>();

	@OneToMany(mappedBy ="fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set <Termin>  termin =  new HashSet<>();


}
