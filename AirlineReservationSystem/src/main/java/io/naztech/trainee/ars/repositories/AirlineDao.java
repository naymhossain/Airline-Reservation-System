package io.naztech.trainee.ars.repositories;

public interface AirlineDao {
	public int getAvailableSeat(String classType, int airline_id);
}
