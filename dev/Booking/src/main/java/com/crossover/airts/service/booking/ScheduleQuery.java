package com.crossover.airts.service.booking;

public class ScheduleQuery {

	private String origin;	
	private String destiny;
	private String departuring;	
	private String returning;
	private int npassengers;
	
	public ScheduleQuery() {
		
	}
	
	public ScheduleQuery(String origin, String destiny, String departuring, String returning,
			int npassengers) {
		this.origin = origin.toString();
		this.destiny = destiny.toString();
		this.departuring = departuring.toString();
		this.returning = returning.toString();
		this.npassengers = npassengers;
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
	public int getNpassengers() {
		return npassengers;
	}

	public void setNpassengers(int npassengers) {
		this.npassengers = npassengers;
	}

	// for debugging purposes
	public String toString() {
	
		StringBuffer str = new StringBuffer();
		str.append("Origin : " + origin + '\n');
		str.append("Destiny : " + destiny + '\n');
		str.append("Departuring : " + departuring + '\n');
		str.append("Returning : " + returning + '\n');
		str.append("N of Passengers : " + npassengers + '\n');		
		
		return str.toString();
	}


}
