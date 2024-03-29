package com.jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jwd.test.model.Racun;
import com.jwd.test.model.TipRacuna;
import com.jwd.test.web.dto.RacunDTO;
import com.jwd.test.web.dto.TipRacunaDTO;

@Component
public class RacunToRacunDto implements Converter<Racun, RacunDTO>{

	@Override
	public RacunDTO convert(Racun source) {
		
		RacunDTO dto=new RacunDTO();
		
		dto.setBankaId(source.getBanka().getId());
		dto.setBankaNaziv(source.getBanka().getNaziv());
		dto.setBrojRacuna(source.getBrojRacuna());
		dto.setId(source.getId());
		dto.setImePrezime(source.getImePrezime());
		dto.setJmbg(source.getJmbg());
		dto.setStanjeRacuna(source.getStanjeRacuna());
		dto.setTipRacunaId(source.getTipRacuna().getId());
		dto.setTipRacunaNaziv(source.getTipRacuna().getNaziv());
	
		return dto;
	}
	
	
	public List<RacunDTO> convert(List<Racun> source) {
		List<RacunDTO> dto=new ArrayList<RacunDTO>();
		
		for(Racun r:source)
			dto.add(convert(r));
		
		return dto;
	}

}
