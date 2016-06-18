package com.crossover.airts.service.booking;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

	private final static long serialVersionUID = 1L;

	//
	// Data members
	//
	private Integer id;
	private Integer owner;
	private ReservationState resState;
	private Schedule depSchedule;
	private Schedule retSchedule;	
	private ReservationTransaction transaction;
	private Integer nSeats;
	private Double totalCosts;

	//
	// Accessors/Mutators
	//
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer res_id) {
		this.id = res_id;
	}
	
	@Column(name = "reservation_owner")
	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")			
	public ReservationState getState() {
		return resState;
	}

	public void setState(ReservationState state) {
		this.resState = state;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id", insertable=false, updatable=false)		
	public Schedule getDepSchedule() {
		return depSchedule;
	}

	public void setDepSchedule(Schedule depSchedule) {
		this.depSchedule = depSchedule;
	}


	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id", insertable=false, updatable=false)				
	public Schedule getRetSchedule() {
		return retSchedule;
	}

	public void setRetSchedule(Schedule retSchedule) {
		this.retSchedule = retSchedule;
	}

	@Column(name = "reservation_nseats")	
	public Integer getnSeats() {
		return nSeats;
	}

	public void setnSeats(Integer nSeats) {
		this.nSeats = nSeats;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")				
	public ReservationTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(ReservationTransaction transaction) {
		this.transaction = transaction;
	}
	
	@Column(name="reservation_total_costs")				
	public Double getTotalCost() {
		return totalCosts;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCosts = totalCost;
	}
	
	//
	// Methods
	//	
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		str.append("Id : " + id + '\n');
		str.append("Owner : " + owner + '\n');
	//	str.append("State : " + state + '\n');
		str.append("Departure : " + depSchedule + '\n');
		str.append("Return : " + retSchedule + '\n');
		str.append("N of Seats : " + nSeats + '\n');		
		str.append("Transaction : " + transaction + '\n');
		str.append("Total Cost : " + totalCosts + '\n');
		
		return str.toString();
	}


}
