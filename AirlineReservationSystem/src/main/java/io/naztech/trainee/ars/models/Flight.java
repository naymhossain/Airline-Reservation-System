package io.naztech.trainee.ars.models;

public class Flight {
	private int id, airline_id, bClassOccupied, eClassOccupied;
	private String name, route, date, time;
	public int getId() {
		return id;
	}
	
	
	
	public int getbClassOccupied() {
		return bClassOccupied;
	}



	public void setbClassOccupied(int bClassOccupied) {
		this.bClassOccupied = bClassOccupied;
	}



	public int geteClassOccupied() {
		return eClassOccupied;
	}



	public void seteClassOccupied(int eClassOccupied) {
		this.eClassOccupied = eClassOccupied;
	}



	public void setId(int id) {
		this.id = id;
	}
	public int getAirline_id() {
		return airline_id;
	}
	public void setAirline_id(int airline_id) {
		this.airline_id = airline_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
