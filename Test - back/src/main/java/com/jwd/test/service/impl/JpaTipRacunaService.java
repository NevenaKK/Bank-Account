package com.jwd.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwd.test.model.TipRacuna;
import com.jwd.test.repository.TipRacunaRepository;
import com.jwd.test.service.TipRacunaService;

@Service
public class JpaTipRacunaService implements TipRacunaService{

	@Autowired
	TipRacunaRepository tipRacunaRepository;
	
	@Override
	public List<TipRacuna> findAll() {
		return tipRacunaRepository.findAll();
	}

	@Override
	public TipRacuna findOne(Long id) {
		Optional<TipRacuna> tipRacuna=tipRacunaRepository.findById(id);
		
		if(tipRacuna.isPresent())
			return tipRacuna.get();
		return null;
	}

}
