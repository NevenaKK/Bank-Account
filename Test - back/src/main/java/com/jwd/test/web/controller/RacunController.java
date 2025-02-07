package com.jwd.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwd.test.model.Racun;
import com.jwd.test.service.RacunService;
import com.jwd.test.support.RacunDtoToRacun;
import com.jwd.test.support.RacunToRacunDto;
import com.jwd.test.web.dto.RacunDTO;

@RestController
@RequestMapping(value = "/api/racuni", produces = MediaType.APPLICATION_JSON_VALUE)

public class RacunController {
	
	@Autowired
	RacunService racunService;
	@Autowired
	RacunDtoToRacun toRacun;
	@Autowired
	RacunToRacunDto toRacunDto;

	 @GetMapping
	    public ResponseEntity<List<RacunDTO>> getAll(
	    		 @RequestParam(required=false) String jmbg,
	             @RequestParam(required=false) Long bankaId,
	    		 @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo){
	    		
		 Page<Racun> racuni=racunService.search(jmbg, bankaId, pageNo);
		 
		 HttpHeaders headers = new HttpHeaders();
	     headers.add("Total-Pages", Integer.toString(racuni.getTotalPages()));
	     
	     return new ResponseEntity<List<RacunDTO>>(toRacunDto.convert(racuni.getContent()),headers,HttpStatus.OK);
	    	
	           
	    }
	 
	 @GetMapping("/{id}") 
	 public ResponseEntity<RacunDTO> getOne(@PathVariable Long id){
		 
		 Racun racun=racunService.findOne(id);
		 
		 if(racun != null) 
	            return new ResponseEntity<>(toRacunDto.convert(racun), HttpStatus.OK);
	        else 
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        
 
	 }
	 

	 
	 
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<RacunDTO> create (@Valid @RequestBody RacunDTO racunDTO){
		  
		  Racun racun=toRacun.convert(racunDTO);
		  Racun sacuvaniRacun=racunService.save(racun);
		  
		  
		  return new ResponseEntity<RacunDTO>(toRacunDto.convert(sacuvaniRacun),HttpStatus.CREATED);
 
	  }
	 
	 @DeleteMapping("/{id}")
	  public ResponseEntity<RacunDTO> delete (@PathVariable Long id){

		 try { 
			 
			 Racun obrisanRacun=racunService.delete(id);
			  if(obrisanRacun!=null) 	
				  return new ResponseEntity<RacunDTO>(HttpStatus.NO_CONTENT);			  			  
			  else
				  return new ResponseEntity<RacunDTO>(HttpStatus.NOT_FOUND);
			  
		    } catch (Exception e) {
		      return new ResponseEntity<RacunDTO>(HttpStatus.FORBIDDEN);
		    }
		 
		 
		
		  
	  }
	 
	 @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<RacunDTO> update(@PathVariable Long id,@Valid @RequestBody RacunDTO racunDTO){
		  
		  if(!id.equals(racunDTO.getId()))
			  return new ResponseEntity<RacunDTO>(HttpStatus.BAD_REQUEST);
		  
		  Racun racun= toRacun.convert(racunDTO);
		  Racun izmenjeniRacun=racunService.update(racun);
		  
		  return new ResponseEntity<RacunDTO>(toRacunDto.convert(izmenjeniRacun),HttpStatus.OK);
		  
	  }
	 
	  @GetMapping(value = "/prenos")
	  public ResponseEntity<Racun> prenosSaRacuna(
	    		 @RequestParam(required=true) String racunUplatioca,
	             @RequestParam(required=true) String racunPrimaoca,
	    		 @RequestParam(required=true) int iznos){
		  
		   
		 boolean prenos= racunService.prenos(racunUplatioca, racunPrimaoca, iznos);
		 
		 if(prenos)  
			 
			 return new ResponseEntity<Racun>(HttpStatus.OK);
		 else
			 return new ResponseEntity<Racun>(HttpStatus.BAD_REQUEST);
		  
	  }
	 
	 
	 
	 
	 @ExceptionHandler(value = DataIntegrityViolationException.class)
		public ResponseEntity<Void> handle() {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}


	
}
