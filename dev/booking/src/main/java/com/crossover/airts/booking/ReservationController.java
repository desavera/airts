package com.crossover.airts.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
	
    @Autowired
    private ReservationRepository reservationRepo;
    

    @RequestMapping("/bsearch/{owner_id}")
    public List<Reservation> findReservations(@PathVariable(value="owner_id") Integer owner_id) {    	
    	List<Reservation> reports = reservationRepo.findByOwner(owner_id);
        return reports;
    }
    
    @RequestMapping("/bsearch")
    public List<Reservation> findAllReservations() {    	
    	List<Reservation> reports = reservationRepo.findAll();
        return reports;
    }
}