package com.jwd.test.service;

import java.util.List;


import com.jwd.test.model.Banka;


public interface BankaService {


	List<Banka> findAll();
	Banka findOne(Long id);
	
}
