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
import com.jwd.test.model.TipRacuna;
import com.jwd.test.service.TipRacunaService;
import com.jwd.test.support.TipRacunaToTipRacunaDto;
import com.jwd.test.web.dto.BankaDTO;
import com.jwd.test.web.dto.TipRacunaDTO;


@RestController
@RequestMapping(value = "/api/tipovi-racuna", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipRacunaController {

	@Autowired 
	TipRacunaService tipRacunaService;
	
	@Autowired
	TipRacunaToTipRacunaDto toTipRacunaDto;
	
	 @GetMapping
	   public ResponseEntity<List<TipRacunaDTO>> getAll(){
	    		
		 List<TipRacuna> tipoviRacuna=tipRacunaService.findAll();
		 
	     return new ResponseEntity<List<TipRacunaDTO>>(toTipRacunaDto.convert(tipoviRacuna),HttpStatus.OK);
	    	
	           
	    }
	  
	  
	  @GetMapping("/{id}") 
		 public ResponseEntity<TipRacunaDTO> getOne(@PathVariable Long id){
			 
		  TipRacuna tipRacuna=tipRacunaService.findOne(id);
			 
			 if(tipRacuna != null) 
		            return new ResponseEntity<>(toTipRacunaDto.convert(tipRacuna), HttpStatus.OK);
		        else 
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        
	 
		 }
}
