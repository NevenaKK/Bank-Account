package com.jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jwd.test.model.Banka;
import com.jwd.test.web.dto.BankaDTO;

@Component
public class BankaToBankaDto implements Converter<Banka, BankaDTO>{

	@Override
	public BankaDTO convert(Banka source) {
		BankaDTO dto=new BankaDTO();
		
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setSredstvaBanke(source.getSredstvaBanke());
		
		return dto;
	}
	
	public List<BankaDTO> convert(List<Banka> source) {
		List<BankaDTO> dto=new ArrayList<BankaDTO>();
		
		for(Banka b:source)
			dto.add(convert(b));
		
		return dto;
	}

	
	
}
