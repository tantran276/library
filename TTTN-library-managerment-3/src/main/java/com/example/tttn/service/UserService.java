 package com.example.tttn.service;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tttn.entity.User;
import com.example.tttn.mapper.RegistrationRequestToUser;
import com.example.tttn.payload.request.RegistrationRequest;
import com.example.tttn.repository.UserRepository;
import com.example.tttn.security.PasswordEncoder;

@Service
public class UserService implements UserDetailsService{

	private final static String USER_NOT_FOUND = "Tài khoản %s không tồn tại!";
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	private EmailValidator emailValidator = EmailValidator.getInstance();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByUsername(username).orElseThrow(() ->
			new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
	}
	
	public User findByUsername (String username) {
		return userRepository.findByUsername(username).orElseThrow(() ->
			new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
	}
	
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}
	
	public User createUser(RegistrationRequest request) {
		User user = RegistrationRequestToUser.toUser(request);
		String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
	
	public boolean validateEmail(String email) {
		return emailValidator.isValid(email);
	}
}
