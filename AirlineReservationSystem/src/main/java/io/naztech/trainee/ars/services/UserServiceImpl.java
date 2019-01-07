package io.naztech.trainee.ars.services;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.naztech.trainee.ars.models.User;
import io.naztech.trainee.ars.repositories.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	

	@Override
	public User validUser(String name, String password) {
		for (User dUser : getAll()) {
			if(name.equals(dUser.getName()) && password.equals(dUser.getPassword())) {
				return dUser;
			}
		}
		return null;
	}


	@Override
	public ArrayList<User> getAll() {
		return dao.getAll();
	}


	@Override
	public boolean deleteUser(int id) {
		return dao.delete(id);
	}


	@Override
	public boolean updateUser(User user) {
		return dao.update(user);
	}

}
