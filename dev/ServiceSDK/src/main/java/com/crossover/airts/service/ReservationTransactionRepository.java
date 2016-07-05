package com.crossover.airts.service;


import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationTransactionRepository extends JpaRepository<ReservationTransaction, Integer> {	
	List<ReservationTransaction> findAll();
}