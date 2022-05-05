package com.example.tttn.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tttn.payload.request.RegistrationRequest;
import com.example.tttn.service.RegistrationService;
import com.example.tttn.service.UserService;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping
	public String register(@RequestBody RegistrationRequest request) {
		return registrationService.register(request);
	}
}
