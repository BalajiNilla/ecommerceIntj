package com.assignment.project.contollers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.project.DTO.user.ResponseDto;
import com.assignment.project.DTO.user.SigninDto;
import com.assignment.project.DTO.user.SigninResponseDto;
import com.assignment.project.DTO.user.SignupDto;
import com.assignment.project.Exception.CustomException;
import com.assignment.project.Repositories.UserRepository;
import com.assignment.project.services.AuthenticationService;
import com.assignment.project.services.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

//    @GetMapping("/all")
//    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
//        authenticationService.authenticate(token);
//        return userRepository.findAll();
//    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    //TODO token should be updated
    @PostMapping("/signIn")
    public SigninResponseDto SignIn(@RequestBody SigninDto signInDto) throws CustomException { 
    	return userService.signIn(signInDto);
  }
}