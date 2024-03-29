package com.jwd.test.web.dto;

import javax.persistence.Column;

public class BankaDTO {

	 private Long id;
		
	
	    private String naziv;
		
	
		 private int sredstvaBanke;


		public BankaDTO() {
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
		 
		 
}
