package com.crossover.airts.model;

import java.util.Date;
import java.util.List;
import java.util.Comparator;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crossover.airts.flightsearch.FlightSearchQuery;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	Schedule findBySchedule_Id(Integer id);
	List<Schedule> findAll();
	List<Schedule> findByQueryParam(FlightSearchQuery query);	
}