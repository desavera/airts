package com.crossover.airts.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reservation_transaction")
public class ReservationTransaction {
	
	//
	// Data Members
	//
	private Integer transaction_id;                  
	private Integer broker;            	
	private Integer brokerTransaction_id; 
	private Date timestamp; 
	
	//
	// Accessors/Mutators
	//
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "transaction_timestamp")	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "transaction_broker")
	public Integer getBroker() {
		return broker;
	}
	public void setBroker(Integer broker) {
		this.broker = broker;
	}
	
	@Column(name = "transaction_broker_transaction_id")
	public Integer getBrokerTransaction_id() {
		return brokerTransaction_id;
	}
	public void setBrokerTransaction_id(Integer brokerTransaction_id) {
		this.brokerTransaction_id = brokerTransaction_id;
	}

}
