package com.crossover.airts.model;

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
	private Integer res_id;
	private Integer owner;
	private ReservationState state;
	private Schedule depSchedule;
	private Schedule retSchedule;	
	private ReservationTransaction transaction;
	private Integer nSeats;
	private Double totalCost;

	//
	// Accessors/Mutators
	//
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getRes_id() {
		return res_id;
	}

	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}
	
	@Column(name = "reservation_owner")
	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="state_id")			
	public ReservationState getState() {
		return state;
	}

	public void setState(ReservationState state) {
		this.state = state;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="schedule_id")		
	public Schedule getDepSchedule() {
		return depSchedule;
	}

	public void setDepSchedule(Schedule depSchedule) {
		this.depSchedule = depSchedule;
	}


	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="schedule_id")				
	public Schedule getRetSchedule() {
		return retSchedule;
	}

	public void setRetSchedule(Schedule retSchedule) {
		this.retSchedule = retSchedule;
	}

	@Column(name = "reservation_seats")	
	public Integer getnSeats() {
		return nSeats;
	}

	public void setnSeats(Integer nSeats) {
		this.nSeats = nSeats;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="transaction_id")				
	public ReservationTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(ReservationTransaction transaction) {
		this.transaction = transaction;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="transaction_total_costs")				
	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	//
	// Methods
	//	
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		str.append("Id : " + res_id + '\n');
		str.append("Owner : " + owner + '\n');
		str.append("State : " + state + '\n');
		str.append("Departure : " + depSchedule + '\n');
		str.append("Return : " + retSchedule + '\n');
		str.append("N of Seats : " + nSeats + '\n');		
		str.append("Transaction : " + transaction + '\n');
		str.append("Total Cost : " + totalCost + '\n');
		
		return str.toString();
	}


}
