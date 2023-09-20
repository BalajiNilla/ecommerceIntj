package com.assignment.project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.project.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	  List<User> findAll();

	    User findByEmail(String email);

	    User findUserByEmail(String email);

}
