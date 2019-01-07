package io.naztech.trainee.ars.services;

import java.util.List;

import io.naztech.trainee.ars.models.Flight;

public interface FlightService {
	public int saveFlight(Flight flight);
	public List<Flight> getAll();
	public int getAvailableSeat(String classType,int id, int airline_id);
}
