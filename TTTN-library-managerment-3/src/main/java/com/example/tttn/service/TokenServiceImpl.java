package com.example.tttn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tttn.entity.Token;
import com.example.tttn.entity.User;
import com.example.tttn.repository.TokenRepository;

@Service
public class TokenServiceImpl implements TokenService{

	@Autowired
	private TokenRepository tokenRepository;
	
	@Override
	public Token createToken(Token token) {
		Token temp = tokenRepository.findByUser(token.getUser());
		if(temp != null) {
			token.setId(temp.getId());
		}
		return tokenRepository.saveAndFlush(token);
	}

	@Override
	public boolean existsByUser(User user) {
		return tokenRepository.existsByUser(user);
	}


}
