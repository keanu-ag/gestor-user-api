package com.gestor.users.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	public User findByEmail(String email);
	public User findByNombre(String nombre);
	public User findByEmailAndPassword(String email, String password);
	public User findByNombreAndPassword(String nombre, String password);
}
