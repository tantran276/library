package com.example.tttn.payload.response;

import java.util.Date;

import com.example.tttn.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfo {

	private long id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private Date dateOfBirth;
	private UserRole roles;
	
}
