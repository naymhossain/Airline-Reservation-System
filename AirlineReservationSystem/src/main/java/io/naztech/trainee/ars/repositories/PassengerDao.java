package io.naztech.trainee.ars.repositories;

import java.util.List;

import io.naztech.trainee.ars.models.Passenger;

public interface PassengerDao {
	public int save(Passenger passenger);
	public List<Passenger> getAll();
}
