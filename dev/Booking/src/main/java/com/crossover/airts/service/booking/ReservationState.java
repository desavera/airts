package com.crossover.airts.service.booking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation_transaction")
public class ReservationState {
	
	//
	// Data Members
	//
	private Integer state_id;
	private Integer next;
	private Integer previous;
	private String name;
	
	//
	// Accessors/Mutators
	//
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getState_id() {
		return state_id;
	}
	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}
	
	@Column(name = "next_state")
	public Integer getNext() {
		return next;
	}
	
	public void setNext(Integer next) {
		this.next = next;
	}
	
	@Column(name = "previous_state")
	public Integer getPrevious() {
		return previous;
	}
	
	public void setPrevious(Integer previous) {
		this.previous = previous;
	}

	@Column(name = "state_name") 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
