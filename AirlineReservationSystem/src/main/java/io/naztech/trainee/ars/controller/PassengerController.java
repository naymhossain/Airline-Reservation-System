package io.naztech.trainee.ars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.naztech.trainee.ars.models.Passenger;
import io.naztech.trainee.ars.services.PassengerService;

@RestController
@CrossOrigin
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	PassengerService service;
	
	@PostMapping("/create")
	public int createPassenger(@RequestBody Passenger passenger) {
		return service.save(passenger);
	}
	
	@GetMapping("/all")
	public List<Passenger> fetchAll(){
		System.out.println("Request for all passenger ...");
		return service.getAll();
	}
}
