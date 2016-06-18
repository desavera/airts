package com.crossover.airts.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.airts.model.Reservation;
import com.crossover.airts.model.ReservationRepository;

@RestController
public class BookingController {
	
    @Autowired
    private ReservationRepository reservationRepo;
    

    @RequestMapping("/bsearch/{owner_id}")
    public List<Reservation> findReservations(@PathVariable(value="owner_id") Integer owner_id) {    	
    	List<Reservation> entities = reservationRepo.findByOwner(owner_id);
        return entities;
    }
    
    @RequestMapping("/bsearch")
    public List<Reservation> findAllReservations() {    	
    	List<Reservation> entities = reservationRepo.findAll();
        return entities;
    }
}
