package com.example.tttn.payload.response;

import java.util.Date;
import java.util.Set;

import com.example.tttn.entity.Role;

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
	private Set<Role> roles;
	
}
