package com.gestor.users.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.gestor.users.model.User;
import com.gestor.users.model.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public User fetchUserByName(String nombre) {
		return repo.findByNombre(nombre);
	}
	
	public User fetchUserByEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}
	
	public User fetchUserByNameAndPassword(String nombre, String password) {
		return repo.findByNombreAndPassword(nombre, password);
	}
	
	public List<User> listUsers() {
		return repo.findAll();
	}
	
	public String encryptPassword(String pwd) {
		return BCrypt.hashpw(pwd, BCrypt.gensalt());
	}
	
	public boolean decodePassword(String tempPwd, String realPwd) {
		boolean flg = BCrypt.checkpw(tempPwd, realPwd);
		return flg;	
	}
	
	public User changePwdAndfechaMod(String password, Date fechaMod, Long id) {
		User userObj = new User();
		repo.findById(id).get().setFechamodificacion(fechaMod);
		
		String encp = encryptPassword(password);
		repo.findById(id).get().setPassword(encp);
		
		userObj = repo.getById(id);
		return userObj;
	}
	
}
