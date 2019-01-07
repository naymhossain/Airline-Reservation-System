package io.naztech.trainee.ars.repositories;

import java.util.List;

import io.naztech.trainee.ars.models.Flight;

public interface FlightDao {
	public List<Flight> getAll();
	public int createFlight(Flight flight);
	public int getOccupiedSeat(String classType, int airline_id);
}
