package com.example.tttn.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tttn.payload.request.RegistrationRequest;
import com.example.tttn.service.UserService;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping
	public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {		
		if (!userService.validateEmail(request.getEmail())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email không hợp lệ");
		}
		if (userService.existsByEmail(request.getEmail())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email đã tồn tại");
		}
		if (userService.existsByUsername(request.getUsername())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên tài khoản đã tồn tại!");
		}
		userService.createUser(request);
		return ResponseEntity.ok().body("Đăng ký thành công");
	}
}
