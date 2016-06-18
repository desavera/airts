package com.crossover.airts.booking;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer res_id;
	    
	    @Column(name = "reservation_owner")
	    private Integer owner;	    
	    
		@Column(name = "reservation_state")
	    private Integer state;
	    	    
		@Column(name = "reservation_schedule")
	    private Integer schedule;
	    
		@Column(name = "reservation_transaction")
	    private Integer transaction;
	    
		@Column(name = "reservation_seats")
	    private String seats;
	    
	    @Temporal(TemporalType.TIMESTAMP)
		@Column(name = "reservation_timestamp")
	    private Date timeStamp;
	    	   
	   
	    //
	    // Accessors/Mutators
	    //
		public Integer getRes_id() {
			return res_id;
		}

		public void setRes_id(Integer res_id) {
			this.res_id = res_id;
		}
		
		public Integer getOwner() {
			return owner;
		}

		public void setOwner(Integer owner) {
			this.owner = owner;
		}

	    public Integer getState() {
			return state;
		}

		public void setState(Integer state) {
			this.state = state;
		}

 	   
		public Date getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(Date timeStamp) {
			this.timeStamp = timeStamp;
		}
	    
	    public String getSeats() {
			return seats;
		}

		public void setSeats(String seats) {
			this.seats = seats;
		}
	    
	    public Integer getTransaction() {
			return transaction;
		}

		public void setTransaction(Integer transaction) {
			this.transaction = transaction;
		}
	    public Integer getSchedule() {
			return schedule;
		}

		public void setSchedule(Integer schedule) {
			this.schedule = schedule;
		}	

		//
		// Methods
		//
	    @PrePersist
	    private void createTimeStamp() {
	    	
	        setTimeStamp(new Date());	        
	       
	    }
	    
	    public Integer numberOfSeats() {
			
			return this.getSeats().split(":").length;		
		}

		
}
