package com.latyshonak.service.beans.security;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityBean implements GrantedAuthority {

	private String role;

	public GrantedAuthorityBean(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return role;
	}
}
