package com.crossover.airts.service.flightsearch;

import java.util.Date;
import java.util.List;
import java.util.Comparator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	Schedule findBySchedule_Id(Integer id);
	Page<Schedule> findAll(Pageable pager);
	List<Schedule> findByOriginAndDestinyAndNseats(Spot qorigin, Spot qdestiny, int npassengers,Pageable pager);	
}