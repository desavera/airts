package com.crossover.airts.service.flightsearch;

import java.util.Date;
import java.util.List;
import java.util.Comparator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	Schedule findById(Integer id);
	Page<Schedule> findAll(Pageable pager);
		              
	//
	@Query("SELECT s FROM Schedule s WHERE (s.origin.id=:#{#origin.id} OR s.origin.id=:#{#destiny.id}) AND (s.numOfSeats > :#{#nseats}) AND (s.departureTime between :#{#departuring} and :#{#returning})")	
	List<Schedule> findByQueryParam(@Param("origin") Spot origin,
									@Param("destiny") Spot destiny,
									@Param("nseats") Integer nseats,
									@Param("departuring") Date departuring,
									@Param("returning") Date returning,											
									Pageable pager);
	

	

}