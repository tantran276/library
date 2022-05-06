package com.example.tttn.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tttn.entity.User;
import com.example.tttn.mapper.UserInfoMapper;
import com.example.tttn.payload.request.LoginRequest;
import com.example.tttn.payload.response.MessageResponse;
import com.example.tttn.security.PasswordEncoder;
import com.example.tttn.service.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping
	public ResponseEntity<?> register(@RequestBody LoginRequest request) {
		User user = userService.findByUsername(request.getUsername());
		if(user == null) {
			return ResponseEntity.ok().body(new MessageResponse("Tài khoản không tồn tại"));
		}
		if (!passwordEncoder.bCryptPasswordEncoder().matches(request.getPassword(), user.getPassword())) {
			return ResponseEntity.ok().body(new MessageResponse("Mật khẩu  không đúng"));
		}
		return ResponseEntity.ok().body(UserInfoMapper.toUserInfo(user));
	}
}
