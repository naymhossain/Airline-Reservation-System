package io.naztech.trainee.ars.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class AirlineDaoImpl implements AirlineDao {
	
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int getAvailableSeat(String classType, int airline_id) {
		String sql = "select "+classType+" from T_ARS_AIRLINE where id=?";
		Integer avalablity =(Integer) jdbc.queryForObject(sql, new Object[] {airline_id}, Integer.class);
		return avalablity;
	}

	

}
