package com.example.tttn.service;

import com.example.tttn.entity.Token;

public interface TokenService {
	Token createToken(Token token);
	boolean existsToken(String value);
}
