package com.kms.stores.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kms.stores.authservice.authDTOs.LoginResponseDTO;
import com.kms.stores.authservice.authDTOs.UserLoginDTO;
import com.kms.stores.authservice.domain.AuthService;

@Controller
@RequestMapping("/api/v1")
public class AuthController {
	@Autowired
	AuthService authService;

	@PostMapping("/authenticate")
	public LoginResponseDTO authenticateUser(UserLoginDTO userLoginDTO) {
		
		return authService.validateandGenerateToken(userLoginDTO);
	}
}
