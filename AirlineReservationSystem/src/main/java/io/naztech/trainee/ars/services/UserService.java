package io.naztech.trainee.ars.services;



import java.util.ArrayList;

import io.naztech.trainee.ars.models.User;

public interface UserService {
	public User validUser(String name, String password);
	public ArrayList<User> getAll();
	public boolean deleteUser(int id);
	public boolean updateUser(User user);
}
