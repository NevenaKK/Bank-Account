package com.jwd.test.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banka {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique = true, nullable = false)
    private String naziv;
	
	 @Column
	 private int sredstvaBanke;
	 
	 @OneToMany(mappedBy = "banka")
	 private List<TipRacuna> tipoviRacuna;
	 
	 @OneToMany(mappedBy = "banka")
	 private List<Racun> racuni;

	public Banka() {
		super();
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

	

	public int getSredstvaBanke() {
		return sredstvaBanke;
	}

	public void setSredstvaBanke(int sredstvaBanke) {
		this.sredstvaBanke = sredstvaBanke;
	}

	public List<TipRacuna> getTipoviRacuna() {
		return tipoviRacuna;
	}

	public void setTipoviRacuna(List<TipRacuna> tipoviRacuna) {
		this.tipoviRacuna = tipoviRacuna;
	}

	public List<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banka other = (Banka) obj;
		return Objects.equals(id, other.id);
	}
	 
	 
}
