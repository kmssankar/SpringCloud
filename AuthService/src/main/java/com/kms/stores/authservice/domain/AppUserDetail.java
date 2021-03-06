package com.kms.stores.authservice.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kms.stores.authservice.entity.User;

public class AppUserDetail implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user;
	
	public AppUserDetail(User user) {
		this.user =user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.user.getRoles().stream().map(n -> new SimpleGrantedAuthority(n.getName())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
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
		return true;
	}

}
