package com.crossover.airts.service;

import java.util.Date;
import java.util.List;
import java.util.Comparator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	List<Reservation> findByOwner(Integer id,Pageable pages);	
	Page<Reservation> findAll(Pageable pager);	
}