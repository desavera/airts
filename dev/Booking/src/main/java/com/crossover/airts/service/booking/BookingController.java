package com.crossover.airts.service.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
	
    @Autowired
    private ReservationRepository reservationRepo;
    

    @RequestMapping("/bsearch/{owner_id}")
    public List<Reservation> findReservations(
    		final @RequestParam(defaultValue = "0", required = false) int page,
     	    final @RequestParam(defaultValue = "10", required = false) int pageSize,
     	    @PathVariable(value="owner_id") Integer owner_id) {
    	Pageable topTen = new PageRequest(page, pageSize);
    	List<Reservation> entities = reservationRepo.findByOwner(owner_id,topTen);
        return entities;
    }
    
    @RequestMapping("/bsearch")
    public Page<Reservation> findAllReservations(
    		final @RequestParam(defaultValue = "0", required = false) int page,
     	    final @RequestParam(defaultValue = "10", required = false) int pageSize) { 
    	Pageable pager = new PageRequest(page, pageSize);
    	Page<Reservation> entities = reservationRepo.findAll(pager);
        return entities;
    }
}
