package crossover.airts.booking;

import java.util.List;  

import javax.ws.rs.DELETE;  
import javax.ws.rs.GET;  
import javax.ws.rs.POST;  
import javax.ws.rs.PUT;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;    

@Path("/reservationspots")
public class ReservationSpotController {
		  	 
	   
	 ReservationSpotService service=new ReservationSpotService();  
	   
	 @GET  
	 @Produces(MediaType.APPLICATION_JSON)  
	 public List<ReservationSpot> getReservationSpots()  
	 {  
	    
	  List<ReservationSpot> listOfSpots=service.getAll();  
	  return listOfSpots;  
	 }  
	  
	 @GET  
	 @Path("/{id}")  
	 @Produces(MediaType.APPLICATION_JSON)  
	 public ReservationSpot getReservationSpotById(@PathParam("id") int id)  
	 {  
		try {
			return service.getById(id);
		} catch (ReservationSpotNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ReservationSpotMock();
	 }  	      
	 
	 @POST  
	 @Produces(MediaType.APPLICATION_JSON)  
	 public ReservationSpot addReservationSpot(ReservationSpot reservationSpot)  
	 {  
	  return service.add(reservationSpot);  
	 }  
	  
	 @PUT  
	 @Produces(MediaType.APPLICATION_JSON)  
	 public ReservationSpot updateReservationSpot(ReservationSpot reservationSpot)  
	 {  
	  return service.update(reservationSpot);  
	    
	 }  
	   
	 @DELETE  
	 @Path("/{id}")  
	 @Produces(MediaType.APPLICATION_JSON)  
	 public void deleteReservationSpot(@PathParam("id") int id)  
	 {  
	   service.deleteById(id);  
	    
	 }  

	  
}
