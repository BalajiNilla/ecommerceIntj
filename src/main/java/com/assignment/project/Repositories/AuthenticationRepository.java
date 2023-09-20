package com.assignment.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.project.models.AuthenticationToken;
import com.assignment.project.models.User;

public interface AuthenticationRepository extends JpaRepository<AuthenticationToken, Integer>{

	AuthenticationToken findByUser(User user);
	AuthenticationToken findByToken(String token);

}
