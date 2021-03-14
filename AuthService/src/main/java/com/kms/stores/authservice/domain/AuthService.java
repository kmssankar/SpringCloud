package com.kms.stores.authservice.domain;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.kms.stores.authservice.authDTOs.LoginResponseDTO;
import com.kms.stores.authservice.authDTOs.UserLoginDTO;

@Service
public class AuthService {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	public LoginResponseDTO validateandGenerateToken(UserLoginDTO userLoginDTO) {
		
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userLoginDTO.getUsername(), userLoginDTO.getPassword())
		);
		
		final UserDetails userdetails = userDetailsService.loadUserByUsername(userLoginDTO.getUsername());
		final String jwt = jwtUtil.generateToken(userdetails);
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		loginResponseDTO.setGentime(new Date());
		loginResponseDTO.setToken(jwt);
		loginResponseDTO.setRequesteduser(userdetails.getUsername());
		loginResponseDTO.setUserRoles(userdetails.getAuthorities().stream().map(n->n.getAuthority()).collect(Collectors.toList()));
		return loginResponseDTO;
	}
	
}
