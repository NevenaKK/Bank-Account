package com.jwd.test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.jwd.test.model.Banka;
import com.jwd.test.model.Racun;

public interface RacunService {
	
	
	
	Racun findOne(Long id);
	Racun save(Racun racun);
	Racun update(Racun racun);
	Racun delete(Long id);
	
	Racun findByBrojRacuna(String brojRacuna);
	
	Page<Racun> search(String jmbg,Long bankaId,int pageNo);
	
	boolean prenos (String racunUplatioca,String racunPrimaoca,int iznos);
	

	

}
