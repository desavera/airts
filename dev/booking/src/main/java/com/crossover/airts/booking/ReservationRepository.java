package com.crossover.airts.booking;

import java.util.Date;
import java.util.List;
import java.util.Comparator;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	List<Reservation> findByOwner(Integer login);
	List<Reservation> findByTimeStamp(Date referenceDate, Comparator<Date> c);
	List<Reservation> findAll();	
}