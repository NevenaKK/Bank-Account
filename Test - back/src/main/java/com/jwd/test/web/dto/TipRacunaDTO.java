package com.jwd.test.web.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jwd.test.model.Banka;
import com.jwd.test.model.Racun;

public class TipRacunaDTO {

private Long id;
	

    private String naziv;
	
	
	 private int provizija;
	   
	
	 private Long bankaId;
	 private String bankaNaziv;
	public TipRacunaDTO() {
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
	public int getProvizija() {
		return provizija;
	}
	public void setProvizija(int provizija) {
		this.provizija = provizija;
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
