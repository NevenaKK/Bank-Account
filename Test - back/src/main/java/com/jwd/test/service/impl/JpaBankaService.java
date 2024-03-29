package com.jwd.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwd.test.model.Banka;
import com.jwd.test.repository.BankaRepository;
import com.jwd.test.service.BankaService;

@Service
public class JpaBankaService implements BankaService {

	@Autowired
	BankaRepository bankaRepository;
	
	@Override
	public List<Banka> findAll() {
		return bankaRepository.findAll();
	}

	@Override
	public Banka findOne(Long id) {
		Optional<Banka> banka=bankaRepository.findById(id);
		
		if(banka.isPresent())
			return banka.get();
		return null;
	}

}
