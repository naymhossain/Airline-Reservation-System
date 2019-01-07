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

import io.naztech.trainee.ars.models.Flight;

@Repository
public class FlightDaoImpl implements FlightDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	
	@Override
	public List<Flight> getAll() {
		String sql = "select * from T_ARS_FLIGHT";
		RowMapper<Flight> row = new BeanPropertyRowMapper<Flight>(Flight.class);
		return jdbc.query(sql, row);
	}

	@Override
	public int createFlight(Flight flight) {
		String sql = "insert into T_ARS_FLIGHT(airline_id, name, route, date, time, bClassOccupied, eClassOccupied)"
				+ " values(?,?,?,?,?)";
		GeneratedKeyHolder key = new GeneratedKeyHolder();
		jdbc.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, flight.getAirline_id());
				ps.setString(2, flight.getName());
				ps.setString(3, flight.getRoute());
				ps.setString(4, flight.getDate());
				ps.setString(5, flight.getTime());
				ps.setInt(6, 0);
				ps.setInt(7, 0);
				return ps;
			}
		}, key);
		
		return key.getKey().intValue();
	}

	@Override
	public int getOccupiedSeat(String classType, int id) {
		String sql = "select "+classType+" from T_ARS_FLIGHT where id=?";
		Integer occupiency =(Integer) jdbc.queryForObject(sql, new Object[] {id}, Integer.class);
		return occupiency;
	}

}
