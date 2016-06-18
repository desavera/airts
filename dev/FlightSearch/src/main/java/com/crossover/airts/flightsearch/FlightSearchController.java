package com.crossover.airts.flightsearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.airts.model.Schedule;
import com.crossover.airts.model.ScheduleRepository;

@RestController
public class FlightSearchController {
	
    @Autowired
    private ScheduleRepository scheduleRepo;
    
    
    @RequestMapping(value="/fsearch" , method=RequestMethod.POST)
    public List<Schedule> findSchedulesByQueryParam(@RequestBody FlightSearchQuery query) {
    	
    	 List<Schedule> matchList = new ArrayList();
    	 
    	 List<Schedule> entities = new ArrayList<Schedule>(entityIdMap.values());  
    	 
    	 logger.debug("Quering schedules for : " + '\n' + query);
    	 
    	 for (Schedule entity:entities) {
    		 

    		 // for a match we need to check the spot codes, a same day comparison as well as checking the number of seats available		 
    		 boolean scheduleMatch = false;
    		 
    		 if ((entity.getOrigin().toUpperCase().startsWith(query.getOrigin().toUpperCase())) &&
    			 (entity.getDestiny().toUpperCase().startsWith(query.getDestiny().toUpperCase()))) {			
    		
    			  if (entity.isDeparturingDate(query.getDeparturing()))  
    						
    				  scheduleMatch = true;
    				
    		 } else
    				 
    		 if ((entity.getOrigin().toUpperCase().startsWith(query.getDestiny().toUpperCase())) &&
    			 (entity.getDestiny().toUpperCase().startsWith(query.getOrigin().toUpperCase()))) {
    			 
    			 if (entity.isDeparturingDate(query.getReturning())) 
    		 
    				  scheduleMatch = true;
    			 
    		 }
    							 
    			 			  
    		 if ((scheduleMatch) && (entity.getNseats() >= query.getNpassengers())) {
    			 logger.debug("Matched query for : " + entity);
    			 matchList.add(entity);			 
    		 }			
    	}
    		 		 	 	 
    	return matchList;
    	
    	
    	
    	List<Schedule> entities = scheduleRepo.findByQueryParam(query);
        return entities;
    }    

    @RequestMapping(value="/fsearch/{schedule_id}", method=RequestMethod.PUT)
    public Schedule updateSchedule(@RequestBody Schedule schedule) {    	
    	Schedule entity = scheduleRepo.findBySchedule_Id(schedule.getSchedule_id());
    	
    	entity.update(schedule);
    		
    	
        return entity;
    }       
    
    
    @RequestMapping("/fsearch")
    public List<Schedule> findAllSchedules() {    	
    	List<Schedule> entities = scheduleRepo.findAll();
        return entities;
    }
}
