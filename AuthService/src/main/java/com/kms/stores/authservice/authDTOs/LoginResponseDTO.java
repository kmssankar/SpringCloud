package com.kms.stores.authservice.authDTOs;

import java.util.Date;
import java.util.List;

public class LoginResponseDTO {
	
	String requesteduser;
	String token;
	Date gentime;
	List<String> userRoles;
	
	public List<String> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}
	public String getRequesteduser() {
		return requesteduser;
	}
	public void setRequesteduser(String requesteduser) {
		this.requesteduser = requesteduser;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getGentime() {
		return gentime;
	}
	public void setGentime(Date gentime) {
		this.gentime = gentime;
	}
}
