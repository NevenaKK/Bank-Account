package com.jwd.test.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jwd.test.model.Banka;
import com.jwd.test.model.Racun;
import com.jwd.test.model.TipRacuna;
import com.jwd.test.repository.BankaRepository;
import com.jwd.test.repository.RacunRepository;
import com.jwd.test.service.BankaService;
import com.jwd.test.service.RacunService;

@Service
public class JpaRacunService implements RacunService{

	@Autowired
	RacunRepository racunRepository;
	
	@Autowired
	BankaRepository bankaRepository;
	

	
	@Override
	public Racun findOne(Long id) {
		Optional<Racun> racun=racunRepository.findById(id);
		
		if(racun.isPresent())
			return racun.get();
		return null;
	}

	@Override
	public Racun save(Racun racun) {
		return racunRepository.save(racun);
	}

	@Override
	public Racun update(Racun racun) {
		return racunRepository.save(racun);
	}

	@Override
	public Racun delete(Long id) {
		Optional<Racun> racun=racunRepository.findById(id);
		if(racun.isPresent()) {
			if(racun.get().getStanjeRacuna()!=0)
				throw new IllegalArgumentException("Stanje računa mora biti 0.");
			else {
				racunRepository.deleteById(id); 
				return racun.get();
			}
		}
		return null;
	}

	@Override
	public Page<Racun> search(String jmbg, Long bankaId, int pageNo) {
		return racunRepository.search(jmbg, bankaId, PageRequest.of(pageNo, 3));
	}

	@Override
	public Racun findByBrojRacuna(String brojRacuna) {
		return racunRepository.findByBrojRacuna(brojRacuna);
	}

	@Override
	public boolean prenos(String racunUplatioca, String racunPrimaoca, int iznos) {
		
		Racun uplatilac=racunRepository.findByBrojRacuna(racunUplatioca);
		Racun primalac=racunRepository.findByBrojRacuna(racunPrimaoca);
		
		Banka banka=uplatilac.getBanka();
		
		int provizija=iznos*uplatilac.getTipRacuna().getProvizija()/100;
		
		 provizija = (provizija<=1000) ? provizija : 1000;
 
		
		if(uplatilac.getStanjeRacuna()>=(iznos+provizija)) {
			
			uplatilac.setStanjeRacuna(uplatilac.getStanjeRacuna()-iznos);
			uplatilac.setStanjeRacuna(uplatilac.getStanjeRacuna()-provizija);			
			save(uplatilac);
			
			primalac.setStanjeRacuna(primalac.getStanjeRacuna()+iznos);			
			save(primalac);
						
			banka.setSredstvaBanke(banka.getSredstvaBanke()+provizija);
			bankaRepository.save(banka);
			
			return true;
		}else
			return false;
	} 


}
