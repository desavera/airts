package com.crossover.airts.model;

import java.util.Date;
import java.util.List;
import java.util.Comparator;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	List<Reservation> findByOwner(Integer id,Pageable pages);
	List<Reservation> findByTimeStamp(Date referenceDate, Comparator<Date> c);
	List<Reservation> findAll();
	
	
	
}