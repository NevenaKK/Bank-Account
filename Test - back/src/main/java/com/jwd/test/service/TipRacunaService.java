package com.jwd.test.service;

import java.util.List;

import com.jwd.test.model.TipRacuna;

public interface TipRacunaService {

	
	List<TipRacuna> findAll();
	TipRacuna findOne(Long id);
}
