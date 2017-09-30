package com.latyshonak.service.beans.security;

import com.latyshonak.service.beans.UsersBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class LoggedAccountBean implements UserDetails {

	private UsersBean user;

	private Collection<GrantedAuthorityBean> authorities;

	public LoggedAccountBean(UsersBean user, Collection<GrantedAuthorityBean> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO: implement real logic...
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO: implement real logic...
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO: implement real logic...
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.getEnabled();
	}

	public UsersBean getUsersBean() {
		return user;
	}
}
