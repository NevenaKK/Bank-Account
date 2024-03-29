package com.jwd.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwd.test.model.TipRacuna;

@Repository
public interface TipRacunaRepository extends JpaRepository<TipRacuna, Long> {

}
