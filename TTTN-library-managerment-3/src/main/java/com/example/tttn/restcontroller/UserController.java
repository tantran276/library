package com.example.tttn.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tttn.mapper.UserInfoMapper;
import com.example.tttn.payload.response.UserInfo;
import com.example.tttn.secutiry.jwt.JwtUtils;
import com.example.tttn.service.interfaces.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/me")
	@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')" )
	public ResponseEntity<?> getUser(@RequestHeader HttpHeaders header) {
		String authorization = header.getFirst("Authorization");
		String username = jwtUtils.getUserNameFromJwtToken(authorization.substring(7));
		UserInfo userInfo = UserInfoMapper.toUserInfo(userService.getUserByUsername(username));
//		return ResponseEntity.ok().body(username);
		return ResponseEntity.ok(userInfo);
	}
	
	@GetMapping()
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> getUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
}
