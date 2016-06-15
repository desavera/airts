package crossover.airts.flightsearch;

import java.io.Serializable;
import java.util.Date;

 
public class Schedule {
	
	
	private int id;	
	private String origin;	
	private String destiny;
	private String departuring;
	private int nseats;
	private double costs;


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

	public boolean isDeparturingDay(String dateString) {
		
		 Date thisDeparture = new Date(Date.parse(this.getDeparturing())); 
		 Date queryDeparture = new Date(Date.parse(dateString));
		 
		 // TODO : replace for Calendar		 
		 if ((thisDeparture.getDay() == queryDeparture.getDay()) &&
			 (thisDeparture.getMonth() == queryDeparture.getMonth()) &&
			 (thisDeparture.getYear() == queryDeparture.getYear()))
			 
			 return true;			 			 			 			
		 
		return false;
	}
	
}
