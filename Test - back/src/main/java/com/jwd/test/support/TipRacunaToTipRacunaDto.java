package com.jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jwd.test.model.Banka;
import com.jwd.test.model.TipRacuna;
import com.jwd.test.web.dto.BankaDTO;
import com.jwd.test.web.dto.TipRacunaDTO;
@Component
public class TipRacunaToTipRacunaDto implements Converter<TipRacuna, TipRacunaDTO>{

	@Override
	public TipRacunaDTO convert(TipRacuna source) {
		
		TipRacunaDTO dto=new TipRacunaDTO();
		
		dto.setBankaId(source.getBanka().getId());
		dto.setBankaNaziv(source.getBanka().getNaziv());
		dto.setId(source.getId());
		dto.setProvizija(source.getProvizija());
		dto.setNaziv(source.getNaziv());
		
		return dto;
	}
	
	public List<TipRacunaDTO> convert(List<TipRacuna> source) {
		List<TipRacunaDTO> dto=new ArrayList<TipRacunaDTO>();
		
		for(TipRacuna t:source)
			dto.add(convert(t));
		
		return dto;
	}

}
