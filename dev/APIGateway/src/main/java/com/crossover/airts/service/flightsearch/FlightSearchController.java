package com.crossover.airts.service.flightsearch;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightSearchController {
	
    @Autowired
    private ScheduleRepository scheduleRepo;
    @Autowired
    private SpotRepository spotRepo;
    
	final Logger logger = Logger.getLogger(FlightSearchController.class); 

    
    @RequestMapping(value="/fsearch" , method=RequestMethod.POST,
		    		consumes = {MediaType.APPLICATION_JSON_VALUE},
		    		produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Schedule> findSchedulesByQueryParam(
    		final @RequestParam(defaultValue = "0", required = false) int page,
     	    final @RequestParam(defaultValue = "10", required = false) int pageSize,
     	    @RequestBody ScheduleQuery query) {
    	
		logger.debug("Quering schedules for : " + '\n' + query);

		Pageable pager = new PageRequest(page, pageSize);

		Spot origin = spotRepo.findByCode(query.getOrigin().toUpperCase());
		Spot destiny = spotRepo.findByCode(query.getDestiny().toUpperCase());

		Date queryDeparture = ScheduleQuery.createQueryDateFromString(query.getDeparturing()); 
		Date queryReturning = ScheduleQuery.createQueryDateFromString(query.getReturning()); 


		List<Schedule> matchList = scheduleRepo.findByQueryParam(origin, destiny, query.getSeats(),queryDeparture,queryReturning,pager);

		return matchList;

    }    

    @RequestMapping(value="/fsearch/{schedule_id}", method=RequestMethod.PUT)
    public Schedule updateSchedule(@RequestBody Schedule schedule) {    	
    	Schedule entity = scheduleRepo.findById(schedule.getId());
    	
    	entity.update(schedule);
    		
    	
        return entity;
    }       
    
    
    @RequestMapping("/fsearch")
    public Page<Schedule> findAllSchedules(
    		final @RequestParam(defaultValue = "0", required = false) int page,
     	    final @RequestParam(defaultValue = "10", required = false) int pageSize) {
    	Pageable pager = new PageRequest(page, pageSize);
    	Page<Schedule> entities = scheduleRepo.findAll(pager);
        return entities;
    }
}
