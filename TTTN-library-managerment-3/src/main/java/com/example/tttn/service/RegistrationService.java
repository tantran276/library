package com.example.tttn.service;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tttn.mapper.RegistrationRequestToUser;
import com.example.tttn.payload.request.RegistrationRequest;

@Service
public class RegistrationService {

	private EmailValidator emailValidator = EmailValidator.getInstance();
	
	@Autowired
	UserService userService;
	
	public String register(RegistrationRequest request) {
		if(!emailValidator.isValid(request.getEmail())) {
			return "Email không hợp lệ!";
		}
		return userService.signUpUser(RegistrationRequestToUser.toUser(request));
	}
}
