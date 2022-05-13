package com.example.tttn.mapper;

import com.example.tttn.entity.User;
import com.example.tttn.payload.request.SignupRequest;

public class SignupRequestMapper {
	
	public static User toUser(SignupRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setDateOfBirth(request.getDateOfBirth());
		user.setEnabled(true);
		return user;
	}
}
