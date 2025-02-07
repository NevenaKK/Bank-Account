package com.jwd.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jwd.test.model.Racun;
@Repository
public interface RacunRepository extends JpaRepository<Racun, Long>{

	
	@Query("SELECT r FROM Racun r WHERE"
			+ "(:jmbg=NULL OR r.jmbg LIKE %:jmbg%) AND "
			+ "(:bankaId=NULL OR r.banka.id=:bankaId)")
	Page<Racun> search(@Param("jmbg") String jmbg,
						@Param("bankaId") Long bankaId,Pageable pageable);

	
	Racun findByBrojRacuna(String brojRacuna);
}
