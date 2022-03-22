package com.gestor.users.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestor.users.model.User;
import com.gestor.users.service.UserService;

@RestController
@RequestMapping("api/v1/")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> listusers(){
		return service.listUsers();
	}
	
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		
		String tempPswd = user.getPassword();
		String encode = service.encryptPassword(tempPswd);
		
		user.setPassword(encode);
		
		String tempEmail = user.getEmail();
		if(tempEmail != null && !"".equals(tempEmail)) {
			User userObj = service.fetchUserByEmail(tempEmail);
			if(userObj != null) {
				throw new Exception("Ya se registró un usuario con el correo " +tempEmail);
			}
		}
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmail();
		String tempNomb = user.getNombre();		
		String tempPassword = user.getPassword();
				
		User userObj = null;
		boolean pwd = false;
		
		if(tempEmail != null && tempPassword != null) {
			userObj = service.fetchUserByEmail(tempEmail);
			if(userObj != null) {
				pwd = service.decodePassword(tempPassword, userObj.getPassword());
			}
			
		}
		
		if(userObj == null && tempNomb != null && tempPassword != null) {
			userObj = service.fetchUserByName(tempNomb);
			if(userObj != null) {
				pwd = service.decodePassword(tempPassword, userObj.getPassword());
			}
		}
		
		if(userObj == null || !pwd) {
			throw new Exception("Usuario o contraseña incorrectos");
		}
		
		return userObj;
	}
	
	@PostMapping("/changePwd")
	@CrossOrigin(origins = "http://localhost:4200")
	public User changePwd(@RequestBody User user) {
		Long id = user.getLogin();
		String tempPassword = user.getPassword();
		Date tempFechMod = (Date) user.getFechamodificacion();
		
		User userObj = null;
		
		if(tempPassword != null && tempFechMod != null) {
			userObj = service.changePwdAndfechaMod(tempPassword, tempFechMod, id);
		}
		
		if(userObj != null) {
			service.saveUser(userObj);
		}
		return userObj;
	}
}
