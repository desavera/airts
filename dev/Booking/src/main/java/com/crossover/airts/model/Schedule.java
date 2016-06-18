package com.crossover.airts.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import org.apache.log4j.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {

	private final static long serialVersionUID = 1L;

	// the default date format
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	final Logger logger = Logger.getLogger(Schedule.class); 



	//
	// Data members
	//
	private Integer schedule_id;
	private Date departureTime;
	private Spot origin;	
	private Spot destiny;
	private Integer nseats;
	private Double costs;	
	private Date arrivingTime;

	//
	// Accessors/Mutators
	//	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(Integer sch_id) {
		this.schedule_id = sch_id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "schedule_departure_time")	
	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "schedule_arriving_time")
	public Date getArrivingTime() {
		return arrivingTime;
	}

	public void setArrivingTime(Date arrivingTime) {
		this.arrivingTime = arrivingTime;
	}
	
	@Column(name = "schedule_costs")	
	public Double getCosts() {
		return costs;
	}

	public void setCosts(Double costs) {
		this.costs = costs;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="spot_id")		
	public Spot getOrigin() {
		return origin;
	}

	public void setOrigin(Spot origin) {
		this.origin = origin;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="spot_id")
	public Spot getDestiny() {
		return destiny;
	}

	public void setDestiny(Spot destiny) {
		this.destiny = destiny;
	}

	@Column(name = "schedule_available_seats")
	public Integer getNseats() {
		return nseats;
	}

	public void setNseats(Integer nseats) {
		this.nseats = nseats;
	}

	
	//
	// Methods
	//
	public void update(Schedule schedule) {

    	if (schedule.getSchedule_id() == this.getSchedule_id()) {
    		
    		this.setDepartureTime(schedule.getDepartureTime());
    		this.setDestiny(schedule.getDestiny());
    		this.setNseats(schedule.getNseats());
    		this.setOrigin(schedule.getOrigin());    		    	
    		
    	} else throw new IllegalArgumentException("invalid update for schedule id : " + schedule.getSchedule_id() + " to entity id : " + this.getSchedule_id());
    			
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + schedule_id;
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
        if (schedule_id != other.schedule_id)
            return false;
        return true;
    }

	public boolean isDeparturingDate(String dateString) {
		
		 
		try {
			
			Date thisDeparture = this.getDepartureTime();
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
	
	public String toString() {
	
		StringBuffer str = new StringBuffer();
		str.append("Id : " + schedule_id + '\n');
		str.append("Origin : " + origin + '\n');
		str.append("Destiny : " + destiny + '\n');
		str.append("Departuring : " + departureTime + '\n');
		str.append("N of Seats : " + nseats + '\n');		
		str.append("Costs : " + costs + '\n');
		
		return str.toString();
	}

		
		    		
}