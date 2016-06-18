package com.crossover.airts.service.flightsearch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class ScheduleQuery {

	
	// the default date format
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	final static Logger logger = Logger.getLogger(ScheduleQuery.class); 

		
	
	private String origin;	
	private String destiny;
	private String departuring;	
	private String returning;
	private Integer seats;
	
	
	
	
	public ScheduleQuery() {
		
	}
	
	public ScheduleQuery(String origin, String destiny, String departuring, String returning,
			int npassengers) {
		this.origin = origin.toString();
		this.destiny = destiny.toString();
		this.departuring = departuring.toString();
		this.returning = returning.toString();
		this.seats = npassengers;
	}

	public String getReturning() {
		return returning;
	}

	public void setReturning(String returning) {
		this.returning = returning;
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
	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer npassengers) {
		this.seats = npassengers;
	}
	
	//
	// Methods
	//
	
	/*
	 * Utility method assuming a full date string format
	 */
	public static Date createQueryDateFromString(String dateString) {
		
		try {
			return SDF.parse(dateString.substring(0, 10) + " 00:00:00");

		} catch (ParseException e) {

			logger.error("Error parsing date string query date strings..." + dateString + e);
		}
		
		return null;

	}

	// for debugging purposes
	public String toString() {
	
		StringBuffer str = new StringBuffer();
		str.append("Origin : " + origin + '\n');
		str.append("Destiny : " + destiny + '\n');
		str.append("Departuring : " + departuring + '\n');
		str.append("Returning : " + returning + '\n');
		str.append("N of Passengers : " + seats + '\n');		
		
		return str.toString();
	}


}
