package com.example.tttn.service;

import com.example.tttn.entity.Token;
import com.example.tttn.entity.User;

public interface TokenService {
	Token createToken(Token token);
	boolean existsByUser(User user);
}
