package com.example.tttn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tttn.mapper.RegistrationRequestToUser;
import com.example.tttn.payload.request.RegistrationRequest;

@Service
public class RegistrationService {

	@Autowired
	UserService userService;
	
	@Autowired
	EmailValidator emailValidator;
	
	public String register(RegistrationRequest request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if (!isValidEmail) {
			return "Email không hợp lệ!";
		}
		return userService.signUpUser(RegistrationRequestToUser.toUser(request));
	}
}
