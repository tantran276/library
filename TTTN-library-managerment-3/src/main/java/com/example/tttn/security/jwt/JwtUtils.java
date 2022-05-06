package com.example.tttn.security.jwt;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.example.tttn.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	@Value("${library.app.jwtSecret")
	private String jwtSecret;
	@Value("${library.app.jwtExpirationMs}")
	private long jwtExpirationMs;
	@Value("${library.app.jwtCookieName}")
	private String jwtCookieName;

	public ResponseCookie generateJwtCookie(User userPrincipal) {
		String jwt = generateTokenFromUsername(userPrincipal.getUsername());
		ResponseCookie cookie = ResponseCookie.from(jwtCookieName, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true)
				.build();
		return cookie;
	}

	public String generateTokenFromUsername(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + jwtExpirationMs);
	}

	public ResponseCookie getCleanJwtCookie() {
		ResponseCookie cookie = ResponseCookie.from(jwtCookieName, null).path("/api").build();
		return cookie;
	}

	public String getJwtFromCookies(HttpServletRequest request) {
		Cookie cookie = WebUtils.getCookie(request, jwtCookieName);
		if (cookie != null) {
			return cookie.getValue();
		} else {
			return null;
		}
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
