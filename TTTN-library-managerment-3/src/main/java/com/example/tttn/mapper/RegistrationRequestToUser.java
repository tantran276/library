package com.example.tttn.mapper;

import com.example.tttn.entity.User;
import com.example.tttn.entity.UserRole;
import com.example.tttn.payload.request.RegistrationRequest;

public class RegistrationRequestToUser {

	public static User toUser(RegistrationRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setEmail(request.getEmail());
		user.setUserRole(UserRole.USER);
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setDateOfBirth(request.getDateOfBirth());
		user.setEnabled(true);
		return user;
	}
}
