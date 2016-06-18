package com.crossover.airts.service.flightsearch;


import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer> {	
	List<Spot> findAll();
	Spot findByCode(String code);
}