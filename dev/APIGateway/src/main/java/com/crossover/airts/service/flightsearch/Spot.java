package com.crossover.airts.service.flightsearch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;

@Entity
@Table(name = "schedule_spot")
public class Spot {

	private final static long serialVersionUID = 1L;

	final Logger logger = Logger.getLogger(Spot.class); 



	//
	// Data members
	//
	private Integer id;
	private String name;	
	private String code;	
	private String timezone;	
		
	//
	// Accessors/Mutators
	//
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Integer getId() {
		return id;
	}

	public void setId(Integer spot_id) {
		this.id = spot_id;
	}

	@Column(name = "spot_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "spot_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "spot_timezone")	
	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	//
	// Methods
	//
	
	// for debugging purposes
	public String toString() {
	
		StringBuffer str = new StringBuffer();
		str.append("Id : " + id + '\n');
		str.append("Name : " + name + '\n');
		str.append("Code : " + code + '\n');
		str.append("Timezone : " + timezone + '\n');

		return str.toString();
	}	
	
}
