package com.crossover.airts.flightsearch;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class FlightSearchSpecifications {

	
	public static Specification<Schedule> () {
	    return new Specification<Schedule> {
	      public <Schedule> Predicate toPredicate(Root<Schedule> root, CriteriaQuery query, CriteriaBuilder cb) {
	        return cb.equal(root.getModel().getAttribute("departureTime"), today);
	      }
	    };
	  }
}
