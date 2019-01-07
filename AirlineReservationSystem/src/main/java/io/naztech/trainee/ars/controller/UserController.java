package io.naztech.trainee.ars.controller;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.naztech.trainee.ars.models.User;
import io.naztech.trainee.ars.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService serv;
	
	
	@GetMapping("/")
	public User getValidity(@RequestParam("name") String name, @RequestParam("password") String password) {
		System.out.println("In rest end point: "+name+" , "+password);
		return serv.validUser(name, password);
	}
	
	@GetMapping("/all")
	public ArrayList<User> getAll(){
		return serv.getAll();
	}
	
	@DeleteMapping("/delete")
	public boolean deleteUser(@RequestParam("id") int id) {
		System.out.println("Request recieved to delete user at id : "+id);
		return serv.deleteUser(id);
	}
	
	@PutMapping("/update") 
	public boolean updateUser(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("role") String role) {
		User user = new User();
		user.setId(id); user.setName(name); user.setEmail(email); user.setPassword(password); user.setRole(role);
		System.out.println("Requext recieved for: "+user.getName());
		return serv.updateUser(user);
	}
	
	
}
