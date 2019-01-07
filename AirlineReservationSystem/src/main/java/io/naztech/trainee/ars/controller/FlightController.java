package io.naztech.trainee.ars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.naztech.trainee.ars.models.Flight;
import io.naztech.trainee.ars.services.FlightService;

@CrossOrigin
@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	FlightService service;

	@GetMapping("/check/seat")
	public int checkSeatAvailability(@RequestParam("classType") String classType, @RequestParam("id") int id,
			@RequestParam("airline_id") int airline_id) {

		return service.getAvailableSeat(classType, id, airline_id);
	}

	@PostMapping("/create")
	public int createFlight(@RequestBody Flight flight) {
		return service.saveFlight(flight);
	}

	@GetMapping("/all")
	public List<Flight> getAll() {
		return service.getAll();
	}
}
