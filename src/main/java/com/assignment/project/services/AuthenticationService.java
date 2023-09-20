package com.assignment.project.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.project.Exception.AuthenticationfailedException;
import com.assignment.project.Repositories.AuthenticationRepository;
import com.assignment.project.models.AuthenticationToken;
import com.assignment.project.models.User;

@Service
public class AuthenticationService {

	@Autowired AuthenticationRepository authenticationRepository;
	
	
	public void saveToken(AuthenticationToken authenticationToken) {
		authenticationRepository.save(authenticationToken);
	}


	public AuthenticationToken gettoken(User user) {
		
		return authenticationRepository.findByUser(user);
		
	}
	
	public void authenticate(String token) {
		
		if(!Objects.nonNull(token)) {
			throw new AuthenticationfailedException("token not present");
		}
		
		if(!Objects.nonNull(getUser(token))){
			throw new AuthenticationfailedException("token is not valid");
			
		}
		
	}
	
	public User getUser(String token) {
		AuthenticationToken Authenticationtoken = authenticationRepository.findByToken(token);
		if(!Objects.nonNull(Authenticationtoken)) {
			return null;
			
		}
		return Authenticationtoken.getUser();
	}
	
	
	
	
}
