package io.naztech.trainee.ars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.naztech.trainee.ars.models.Passenger;
import io.naztech.trainee.ars.repositories.PassengerDao;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	PassengerDao dao;
	
	@Override
	public List<Passenger> getAll() {
		return dao.getAll();
	}

	@Override
	public int save(Passenger passenger) {
		return dao.save(passenger);
	}

}
