package io.naztech.trainee.ars.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import io.naztech.trainee.ars.models.Passenger;

@Repository
public class PassengerDaoImpl implements PassengerDao {	
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public List<Passenger> getAll() {
		String query = "select * from T_ARS_PASSENGER";
		RowMapper<Passenger> row = new BeanPropertyRowMapper<Passenger>(Passenger.class);
		return jdbc.query(query, row);
	}

	@Override
	public int save(Passenger passenger) {
		String sql = "insert into T_ARS_PASSENGER (name, age, nId, phone, gender, occupation)"
				+ " values(?,?,?,?,?,?)";
		GeneratedKeyHolder key = new GeneratedKeyHolder();
		jdbc.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, passenger.getName());
				ps.setInt(2, passenger.getAge());
				ps.setLong(3, passenger.getnId());
				ps.setString(4, passenger.getPhone());
				ps.setString(5, passenger.getGender());
				ps.setString(6, passenger.getOccupation());
				return ps;
			}
		}, key);
		
		return key.getKey().intValue();
	}

}
