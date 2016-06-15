package crossover.airts.flightsearch;

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;


public class FlightSearchServiceMock {
	
	  
 static HashMap<Integer,Schedule> entityIdMap=null;
 final Logger logger = LogManager.getLogger(FlightSearchServiceMock.class); 
  
  
 public FlightSearchServiceMock() {  
  super();  
  
  if(entityIdMap==null)  
  {  
	  
   entityIdMap=new HashMap<Integer,Schedule>();      
   Schedule mock1=new Schedule(1,"01/01/2017 13:00","GIG - Rio de Janeiro","JFK - New York",300,250.2);  
   Schedule mock2=new Schedule(2,"01/01/2017 16:00","GIG - Rio de Janeiro","JFK - New York",500,300.0);   
   Schedule mock3=new Schedule(3,"02/01/2017 10:00","FJK - New York","GIG - Rio de Janeiro",300,312.8);
   Schedule mock4=new Schedule(4,"02/01/2017 13:00","JFK - New York","GIG - Rio de Janeiro",500,533.1);
     
   entityIdMap.put(1,mock1);  
   entityIdMap.put(2,mock2);  
   entityIdMap.put(3,mock3);  
   entityIdMap.put(4,mock4);   
   
  }  
 }  
  
 public List<Schedule> getAll()  
 {  
	 List<Schedule> entities = new ArrayList<Schedule>(entityIdMap.values());  
	 return entities;	 	 	
	 
 }  
  
 public Schedule getById(int id) throws ScheduleNotFoundException
 {  
	 Schedule entity= entityIdMap.get(id);  
  
	 if(entity == null)  
	 {  
		 throw new ScheduleNotFoundException("Schedule with id "+ id + " not found");  
	 }
	 
	 return entity;  
 }  
   
 public static int getMaxId() {
	 
	 int max=0;
	 for (int id:entityIdMap.keySet()) {
		 if(max<=id) max=id;  
  
	 }    
  
	 return max;     
 }

 public Schedule add(Schedule entity) {
	 entity.setId(getMaxId()+1);  
	 entityIdMap.put(entity.getId(), entity);  
	 return entity;  
 }

 public Schedule update(Schedule entity) {
	 
	 if(entity.getId()<=0) {
		 
		 logger.info("invalid entity id for update()...");
		 return null; 
	 }
		
	 
	entityIdMap.put(entity.getId(), entity);  
	return entity;  
 }

 public void deleteById(int id) {
	 entityIdMap.remove(id);
	
 }

 public List<Schedule> getByQueryParams(FlightSearchQuery query) {

	 List<Schedule> matchList = new ArrayList();
	 
	 List<Schedule> entities = new ArrayList<Schedule>(entityIdMap.values());  
	 
	 logger.debug("Quering schedules for : " + query);
	 
	 for (Schedule entity:entities)
		 

		 // for a match we need to check the spot codes, a same day comparison as well as checking the number of seats available
		 if ((entity.getOrigin().startsWith(query.getOrigin()) ||
			  entity.getDestiny().startsWith(query.getDestiny())) &&
			 (entity.isDeparturingDay(query.getDeparturing()) || 
			  entity.isDeparturingDay(query.getReturning())) &&
			 (entity.getNseats() >= query.getNpassengers())) {
			
			 logger.debug("Matched query for : " + entity);
			 matchList.add(entity);
			 
		 }
		 		 	 	 
	 matchList.addAll(entities);
	 return matchList;
 }
 
 
}    
 

