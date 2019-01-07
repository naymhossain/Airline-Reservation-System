package io.naztech.trainee.ars.services;

import java.util.List;

import io.naztech.trainee.ars.models.Passenger;

public interface PassengerService {
	public int save(Passenger passenger);
	public List<Passenger> getAll();
}
