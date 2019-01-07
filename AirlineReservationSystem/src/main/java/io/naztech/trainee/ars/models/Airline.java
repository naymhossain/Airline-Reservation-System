package io.naztech.trainee.ars.models;

public class Airline {
	private int id, capacity, bClassCap, eClassCap;
	private String name, pilotName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getbClassCap() {
		return bClassCap;
	}
	public void setbClassCap(int bClassCap) {
		this.bClassCap = bClassCap;
	}
	public int geteClassCap() {
		return eClassCap;
	}
	public void seteClassCap(int eClassCap) {
		this.eClassCap = eClassCap;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPilotName() {
		return pilotName;
	}
	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}
	
	
}
