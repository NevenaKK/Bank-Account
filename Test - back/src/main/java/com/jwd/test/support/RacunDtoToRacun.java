package com.jwd.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jwd.test.model.Racun;
import com.jwd.test.repository.RacunRepository;
import com.jwd.test.service.BankaService;
import com.jwd.test.service.TipRacunaService;
import com.jwd.test.web.dto.RacunDTO;

@Component
public class RacunDtoToRacun implements Converter<RacunDTO, Racun> {

	@Autowired
	RacunRepository racunRepository;
	
	@Autowired
	BankaService bankaService;
	
	@Autowired
	TipRacunaService tipRacunaService;
	
	@Override
	public Racun convert(RacunDTO source) {
		
		Racun racun=null;
		
		if(source.getId()==null)
			racun=new Racun();
		else
			racun=racunRepository.getOne(source.getId());
		
		if(racun!=null) {
			racun.setBanka(bankaService.findOne(source.getBankaId()));
			racun.setBrojRacuna(source.getBrojRacuna());
			racun.setImePrezime(source.getImePrezime());
			racun.setJmbg(source.getJmbg());
			racun.setStanjeRacuna(source.getStanjeRacuna());
			racun.setTipRacuna(tipRacunaService.findOne(source.getTipRacunaId()));
		}
		
		return racun;
	}

}
