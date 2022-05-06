 package com.example.tttn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tttn.entity.User;
import com.example.tttn.repository.UserRepository;
import com.example.tttn.security.PasswordEncoder;

@Service
public class UserService implements UserDetailsService{

	private final static String USER_NOT_FOUND = "Tài khoản %s không tồn tại!";
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByUsername(username).orElseThrow(() ->
			new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
	}
	
	public String signUpUser(User user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			return "Email đã tồn tại!";
		}
		if (userRepository.existsByUsername(user.getUsername())) {
			return "Tên đăng nhập đã tồn tại!";
		}
		String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		return "Đăng ký thành công";
	}
	
	public User findByUsername (String username) {
		return userRepository.findByUsername(username).orElseThrow(() ->
			new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
	}
}
