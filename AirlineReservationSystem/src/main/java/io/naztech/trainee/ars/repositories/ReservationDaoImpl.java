package io.naztech.trainee.ars.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	JdbcTemplate jdbc;
	
	

}
