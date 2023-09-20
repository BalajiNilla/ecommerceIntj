package com.assignment.project.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.project.DTO.user.ResponseDto;
import com.assignment.project.DTO.user.SigninDto;
import com.assignment.project.DTO.user.SigninResponseDto;
import com.assignment.project.DTO.user.SignupDto;
import com.assignment.project.Exception.AuthenticationfailedException;
import com.assignment.project.Exception.CustomException;

import com.assignment.project.Repositories.UserRepository;
import com.assignment.project.models.AuthenticationToken;
import com.assignment.project.models.User;

import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;

@Service
public class UserService {
	@Autowired UserRepository userRepository;
	@Autowired AuthenticationService authenticationService;

	@Transactional
	public ResponseDto signUp(SignupDto signupDto)  throws CustomException {
        // Check to see if the current email address has already been registered.
        if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
            // If the email address has been registered then throw an exception.
            throw new CustomException("User already exists");
        }
        // first encrypt the password
        String encryptedPassword = signupDto.getPassword();
        try {
            encryptedPassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            
        }


        User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(), encryptedPassword );
        userRepository.save(user);
        ResponseDto responseDto = new ResponseDto("Success", "User created successfully");
        
        AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationService.saveToken(authenticationToken);
        

        return responseDto;
        
        
        
    }
	 String hashPassword(String password) throws NoSuchAlgorithmException {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(password.getBytes());
	        byte[] digest = md.digest();
	        String myHash = DatatypeConverter
	                .printHexBinary(digest).toUpperCase();
	        return myHash;
	    }
	 public SigninResponseDto signIn(SigninDto signInDto) throws CustomException {
	        // first find User by email
	        User user = userRepository.findByEmail(signInDto.getEmail());
	        if(!Objects.nonNull(user)){
	            throw  new AuthenticationfailedException("user not present");
	        }
	        try {
	            // check if password is right
	            if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))){
	                // passowrd doesnot match
	                throw  new AuthenticationfailedException("WrongPassword");
	            }
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
//	            logger.error("hashing password failed {}", e.getMessage());
	            throw new CustomException(e.getMessage());
	        }

	        AuthenticationToken token = authenticationService.gettoken(user);

	        if(!Objects.nonNull(token)) {
	            // token not present
	            throw new CustomException("token not present");
	        }

	        return new SigninResponseDto ("success", token.getToken());
	    }
}
