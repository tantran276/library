package com.example.tttn.payload.response;

import java.util.Date;

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
	
	
}
