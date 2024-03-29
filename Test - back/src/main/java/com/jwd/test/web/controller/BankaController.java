package com.jwd.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwd.test.model.Banka;
import com.jwd.test.service.BankaService;
import com.jwd.test.support.BankaToBankaDto;
import com.jwd.test.web.dto.BankaDTO;

@RestController
@RequestMapping(value = "/api/banke", produces = MediaType.APPLICATION_JSON_VALUE)
public class BankaController {

	@Autowired
	BankaService bankaService;
	@Autowired
	BankaToBankaDto toBankaDto;
	
	  @GetMapping
	   public ResponseEntity<List<BankaDTO>> getAll(){
	    		
		 List<Banka> banke=bankaService.findAll();
		 
	     return new ResponseEntity<List<BankaDTO>>(toBankaDto.convert(banke),HttpStatus.OK);
	    	
	           
	    }
	  
	  
	  @GetMapping("/{id}") 
		 public ResponseEntity<BankaDTO> getOne(@PathVariable Long id){
			 
		  Banka banka=bankaService.findOne(id);
			 
			 if(banka != null) 
		            return new ResponseEntity<>(toBankaDto.convert(banka), HttpStatus.OK);
		        else 
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        
	 
		 }
	  
	  
	
	
	
}
