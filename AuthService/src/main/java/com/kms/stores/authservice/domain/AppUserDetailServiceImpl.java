package com.kms.stores.authservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kms.stores.authservice.entity.User;
import com.kms.stores.authservice.repository.UserRepository;

public class AppUserDetailServiceImpl implements UserDetailsService {
    @Autowired 
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user=null;
		 user = userRepository.getUserByUserName(username).orElse(null);
		 if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
		 return new AppUserDetail(user);
	}

}
