package com.crossover.airts.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation_state")
public class ReservationState {
	
	//
	// Data Members
	//
	private Integer id;
	private Integer next;
	private Integer previous;
	private String name;
	
	//
	// Accessors/Mutators
	//
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer state_id) {
		this.id = state_id;
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

	@Column(name = "name") 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
