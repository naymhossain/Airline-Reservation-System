package io.naztech.trainee.ars.repositories;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.naztech.trainee.ars.models.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static ArrayList<User> users;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ArrayList<User> getAll() { 
		// fetchAllUser();
		String queryString = "SELECT * FROM T_ARS_USER";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		users = (ArrayList<User>) this.jdbcTemplate.query(queryString, rowMapper);
		return users;
	}

	@Override
	public boolean delete(int id) {
		String queryString = "delete from T_ARS_USER where id=?";
		jdbcTemplate.update(queryString, id);
		return true;
	}

	@Override
	public boolean update(User user) {
		String queryString = "update T_ARS_USER set name=?, email=?, password=?, role=? where id=?";
		jdbcTemplate.update(queryString, user.getName(), user.getEmail(), user.getPassword(), user.getRole(),
				user.getId());
		return true;
	}

}
