package crossover.airts.booking;

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;

import org.hibernate.Session;  
  


public class ReservationSpotService {
	
	  
 static HashMap<Integer,ReservationSpot> reservationSpotIdMap=null;  
  
  
 public ReservationSpotService() {  
  super();  
  
  if(reservationSpotIdMap==null)  
  {  
   reservationSpotIdMap=new HashMap<Integer,ReservationSpot>();  
   // Creating some object of countries while initializing  
   ReservationSpot indiaReservationSpot=new ReservationSpot(1, "Aeroporto Tom Jobim","GIG");  
   ReservationSpot chinaReservationSpot=new ReservationSpot(2, "Aeroport Santos Dumond","SDT");  
  
  
   reservationSpotIdMap.put(1,indiaReservationSpot);  
   reservationSpotIdMap.put(2,chinaReservationSpot);  
  }  
 }  
  
 public List<ReservationSpot> getAll()  
 {  
	 //List<ReservationSpot> spots = new ArrayList<ReservationSpot>(reservationSpotIdMap.values());  
	 //return spots;
	 
	 Session session = HibernateUtil.getSessionFactory().openSession();
     session.beginTransaction();

     @SuppressWarnings("unchecked")
     List<ReservationSpot> spots = (List<ReservationSpot>) session.createQuery(
             " FROM ReservationSpot s ORDER BY s.name ASC").list();

     session.getTransaction().commit();
     session.close();
     return spots;	 
	 
	 
 }  
  
 public ReservationSpot getById(int id) throws ReservationSpotNotFoundException
 {  
	 ReservationSpot ReservationSpot= reservationSpotIdMap.get(id);  
  
	 if(ReservationSpot == null)  
	 {  
		 throw new ReservationSpotNotFoundException("ReservationSpot with id "+ id + " not found");  
	 }
	 
	 return ReservationSpot;  
 }  
   
 public static int getMaxId() {
	 
	 int max=0;
	 for (int id:reservationSpotIdMap.keySet()) {
		 if(max<=id) max=id;  
  
	 }    
  
	 return max;     
 }

 public ReservationSpot add(ReservationSpot spot) {
	 spot.setId(getMaxId()+1);  
	 reservationSpotIdMap.put(spot.getId(), spot);  
	 return spot;  
 }

 public ReservationSpot update(ReservationSpot spot) {
	 
	 if(spot.getId()<=0)  
		return null;
	 
	reservationSpotIdMap.put(spot.getId(), spot);  
	return spot;  
 }

 public void deleteById(int id) {
	 reservationSpotIdMap.remove(id);
	
 }  
}    
 

