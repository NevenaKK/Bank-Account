package com.jwd.test.web.dto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.jwd.test.model.Banka;
import com.jwd.test.model.TipRacuna;

public class RacunDTO {

    private Long id;
	
	
	private String imePrezime;
	 

	    private String jmbg;
	 
	
	    private String brojRacuna;
	 
	
	    private int stanjeRacuna;
	 
	
	 private Long tipRacunaId;
	 private String tipRacunaNaziv;
	
	 private Long bankaId;
	 private String bankaNaziv;
	public RacunDTO() {
		super();
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
	public Long getTipRacunaId() {
		return tipRacunaId;
	}
	public void setTipRacunaId(Long tipRacunaId) {
		this.tipRacunaId = tipRacunaId;
	}
	public String getTipRacunaNaziv() {
		return tipRacunaNaziv;
	}
	public void setTipRacunaNaziv(String tipRacunaNaziv) {
		this.tipRacunaNaziv = tipRacunaNaziv;
	}
	public Long getBankaId() {
		return bankaId;
	}
	public void setBankaId(Long bankaId) {
		this.bankaId = bankaId;
	}
	public String getBankaNaziv() {
		return bankaNaziv;
	}
	public void setBankaNaziv(String bankaNaziv) {
		this.bankaNaziv = bankaNaziv;
	}
	 
	 
	
}
