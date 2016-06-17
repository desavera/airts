package crossover.airts.flightsearch;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

 
public class Schedule {
	
	
	private int id;	
	private String origin;	
	private String destiny;
	private String departuring;
	private int nseats;
	private double costs;
	
	// the default date format
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	final Logger logger = LogManager.getLogger(Schedule.class); 


	public Schedule() {}
	
	public Schedule(int id,
					String scheduleDepartureTime,
					String scheduleOrigin,
					String scheduleDestiny,
					int availableSeats,
					double scheduleCosts) {
		
		this.id = id;
		this.departuring=scheduleDepartureTime.toString();
		this.origin=scheduleOrigin.toString();
		this.destiny=scheduleDestiny.toString();
		this.nseats=availableSeats;
		this.costs=scheduleCosts;
	}

	public int getId() {
		return id;
	}

	public void setId(int schedule_id) {
		this.id = schedule_id;
	}

	public String getDeparturing() {
		return departuring;
	}

	public void setDeparturing(String scheduleDepartureTime) {
		this.departuring = scheduleDepartureTime;
	}
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String scheduleOrigin) {
		this.origin = scheduleOrigin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String scheduleDestiny) {
		this.destiny = scheduleDestiny;
	}

	public int getNseats() {
		return nseats;
	}

	public void setNseats(int availableSeats) {
		this.nseats = availableSeats;
	}

	public double getCosts() {
		return costs;
	}

	public void setCosts(double scheduleCosts) {
		this.costs = scheduleCosts;
	}
	

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Schedule))
            return false;
        Schedule other = (Schedule) obj;
        if (id != other.id)
            return false;
        return true;
    }

	public boolean isDeparturingDate(String dateString) {
		
		 
		try {
			
			Date thisDeparture = sdf.parse(this.getDeparturing());
			Date queryDeparture = sdf.parse(dateString.substring(0,10) + " 00:00:00");
 
			Calendar calendar = Calendar.getInstance();
			
			calendar.setTime(thisDeparture);
			
			int tyear       = calendar.get(Calendar.YEAR);
			int tmonth      = calendar.get(Calendar.MONTH); 
			int tdayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); 			
		    		
			calendar.setTime(queryDeparture);
			
			int qyear       = calendar.get(Calendar.YEAR);
			int qmonth      = calendar.get(Calendar.MONTH); 
			int qdayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); 					          
			
			
			if ((tdayOfMonth == qdayOfMonth) && (tmonth == qmonth) && (tyear == qyear))
				 return true;			 			 			 			

			
		} catch (ParseException e) {
			
			logger.error("Error parsing date string : " + dateString + e);			
		} 
		 		 				 		
		 
		return false;
	}
	// for debugging purposes
	public String toString() {
	
		StringBuffer str = new StringBuffer();
		str.append("Id : " + id + '\n');
		str.append("Origin : " + origin + '\n');
		str.append("Destiny : " + destiny + '\n');
		str.append("Departuring : " + departuring + '\n');
		str.append("N of Seats : " + nseats + '\n');		
		str.append("Costs : " + costs + '\n');
		
		return str.toString();
	}
}
