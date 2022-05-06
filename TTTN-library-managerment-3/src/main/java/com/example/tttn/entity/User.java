package com.example.tttn.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

	private static final long serialVersionUID = 2564506442832390733L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username", length = 20, nullable = false)
	private String username;

	@Column(name = "password", length = 120, nullable = false)
	private String password;

	@Column(name = "email", length = 50, nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private UserRole userRole;

	@Column(name = "first_name", length = 20, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 20, nullable = false)
	private String lastName;

	@Column(name = "date_of_birth", nullable = false)
	private Date dateOfBirth;

	@Column(name = "enabled", nullable = false)
	private Boolean enabled;
	
	@OneToOne(mappedBy = "user")
	private Token token;
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(authority);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
