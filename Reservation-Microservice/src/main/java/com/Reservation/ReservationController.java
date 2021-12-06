package com.Reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
	
	@GetMapping("/Reservation")
	public String Hello() {
		return "Hello World!!";
	}
}
