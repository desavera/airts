package com.crossover.airts.model;


import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer> {	
	List<Spot> findAll();
	Spot findByCode(String code,Pageable pager);
}