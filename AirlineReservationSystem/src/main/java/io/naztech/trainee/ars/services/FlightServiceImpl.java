package io.naztech.trainee.ars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.naztech.trainee.ars.models.Flight;
import io.naztech.trainee.ars.repositories.AirlineDao;
import io.naztech.trainee.ars.repositories.FlightDao;

@Service
public class FlightServiceImpl implements FlightService{
	
	private String flightColumn, airlineColumn;
	private int flightId, airId;
	
	@Autowired
	FlightDao dao;
	
	@Autowired
	AirlineDao airDao;
	
	@Override
	public List<Flight> getAll(){
		return dao.getAll();
	}

	@Override
	public int saveFlight(Flight flight) {
		return dao.createFlight(flight);
	}

	@Override
	public int getAvailableSeat(String classType, int id, int airline_id) {
		return calculateAvailableSeat(classType, id, airline_id);
	}

	private int calculateAvailableSeat(String classType, int id, int airline_id) {
		if(classType.equals("business")) {
			this.flightColumn = "bClassOccupied";
			this.airlineColumn = "bClassCap";
		}else {
			this.flightColumn = "eClassOccupied";
			this.airlineColumn = "eClassCap";
		}
		
		this.flightId = id;
		this.airId = id;
		return airDao.getAvailableSeat(airlineColumn, airId)-dao.getOccupiedSeat(flightColumn, flightId);
	}
}
