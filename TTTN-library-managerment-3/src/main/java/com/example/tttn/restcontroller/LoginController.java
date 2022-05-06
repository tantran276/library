package com.example.tttn.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tttn.entity.Token;
import com.example.tttn.entity.User;
import com.example.tttn.mapper.UserInfoMapper;
import com.example.tttn.payload.request.LoginRequest;
import com.example.tttn.security.PasswordEncoder;
import com.example.tttn.security.jwt.JwtUtils;
import com.example.tttn.service.TokenService;
import com.example.tttn.service.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private JwtUtils jwtUtils;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
    private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> register(@RequestBody LoginRequest request) {
		User user = userService.findByUsername(request.getUsername());
		if (null == user || !new BCryptPasswordEncoder().matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản hoặc mật khẩu không chính xác");
        }
		Token token = new Token();
		String tokenValue = jwtUtils.generateJwtCookie(user).toString();
		token.setValue(tokenValue);
		token.setUser(user);
		token.setTokenExpDate(jwtUtils.generateExpirationDate());
		tokenService.createToken(token);
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, tokenValue).body(UserInfoMapper.toUserInfo(user));
	}
}
