package io.naztech.trainee.ars.repositories;

import java.util.ArrayList;

import io.naztech.trainee.ars.models.User;

public interface UserDao {
	public ArrayList<User> getAll();
	public boolean delete(int id);
	public boolean update(User user);
}
