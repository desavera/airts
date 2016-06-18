package com.crossover.airts.service.flightsearch;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.airts.model.ScheduleQuery;
import com.crossover.airts.model.Schedule;
import com.crossover.airts.model.ScheduleRepository;
import com.crossover.airts.model.Spot;
import com.crossover.airts.model.SpotRepository;

@RestController
public class FlightSearchController {
	
    @Autowired
    private ScheduleRepository scheduleRepo;
    @Autowired
    private SpotRepository spotRepo;
    
	final Logger logger = Logger.getLogger(FlightSearchController.class); 

    
    @RequestMapping(value="/fsearch" , method=RequestMethod.POST)
    public List<Schedule> findSchedulesByQueryParam(
    		final @RequestParam(defaultValue = "0", required = false) int page,
     	    final @RequestParam(defaultValue = "10", required = false) int pageSize,
     	    @RequestBody ScheduleQuery query) {
    	
		logger.debug("Quering schedules for : " + '\n' + query);

		Pageable pager = new PageRequest(page, pageSize);
		
		Spot qorigin = spotRepo.findByCode(query.getOrigin().toUpperCase(),pager);
		Spot qdestiny = spotRepo.findByCode(query.getDestiny().toUpperCase(),pager);

		List<Schedule> spotsMatch1 = scheduleRepo.findByOriginAndDestinyAndNseats(qorigin, qdestiny,
				query.getNpassengers(),pager);
		List<Schedule> spotsMatch2 = scheduleRepo.findByOriginAndDestinyAndNseats(qdestiny, qorigin,
				query.getNpassengers(),pager);
    	
		List<Schedule> matchList = new ArrayList();
		matchList.addAll(spotsMatch1);
		matchList.addAll(spotsMatch2);

		return matchList;
    }    

    @RequestMapping(value="/fsearch/{schedule_id}", method=RequestMethod.PUT)
    public Schedule updateSchedule(@RequestBody Schedule schedule) {    	
    	Schedule entity = scheduleRepo.findBySchedule_Id(schedule.getSchedule_id());
    	
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
