package crossover.airts.flightsearch;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.DELETE;  
import javax.ws.rs.GET;  
import javax.ws.rs.POST;  
import javax.ws.rs.PUT;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;    

@Path("/fsearch")
public class FlightSearchController {
		  	 	   
	 final FlightSearchServiceMock service=new FlightSearchServiceMock();
	 final Logger logger = LogManager.getLogger(FlightSearchController.class);
	   	 
	 @POST  	 
	 //@Path("/{origin}/{destiny}/{departuring}/{returning}/{npassengers}")  	 
	 @Produces(MediaType.APPLICATION_JSON)  
/*	 public List<Schedule> getSchedulesByQueryParams(@PathParam("origin") String origin,
							 @PathParam("destiny") String destiny,
							 @PathParam("departuring") String departuring,
							 @PathParam("returning") String returning,
							 @PathParam("npassengers") int npassengers)  
*/
	 public List<Schedule> getSchedulesByQueryParams(FlightSearchQuery query)
	 {  

		//FlightSearchQuery query = new FlightSearchQuery(origin,destiny,departuring,returning,npassengers);
		//FlightSearchQuery query = new FlightSearchQuery("GIG","JFK","01/01/2017","01/02/2017",1);
		 
		logger.info("GET method hit for getScheduleByQueryParams()... with query = " + query);		 		 
		return service.getByQueryParams(query);
 
	 }  	      

	 @PUT  
	 @Produces(MediaType.APPLICATION_JSON)  
	 public Schedule updateSchedule(Schedule schedule)  
	 {  
		 logger.info("PUT method hit for updateSchedule()...");
	  return service.update(schedule);  
	    
	 }  
	   
	 @DELETE  
	 @Path("/{id}")  
	 @Produces(MediaType.APPLICATION_JSON)  
	 public void deleteSchedule(@PathParam("id") int id)  
	 {  
		 logger.info("DELETE method hit for deleteSchedule()..."); 
	   service.deleteById(id);  
	    
	 }  

	  
}