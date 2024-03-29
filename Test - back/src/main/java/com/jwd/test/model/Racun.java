package com.jwd.test.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Racun {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @Column( nullable = false)
	private String imePrezime;
	 
	 @Column
	    private String jmbg;
	 
	 @Column
	    private String brojRacuna;
	 
	 @Column
	    private int stanjeRacuna;
	 
	 @ManyToOne
	 private TipRacuna tipRacuna;
	 
	 @ManyToOne
	 private Banka banka;

	public Racun() {
		super();
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
		Racun other = (Racun) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public int getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(int stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}

	public TipRacuna getTipRacuna() {
		return tipRacuna;
	}

	public void setTipRacuna(TipRacuna tipRacuna) {
		this.tipRacuna = tipRacuna;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}
	 
	 

}
