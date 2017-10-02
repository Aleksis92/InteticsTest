package com.latyshonak.service.impl.security;


import com.latyshonak.service.CustomProvider;
import com.latyshonak.service.UsersService;
import com.latyshonak.service.beans.RoleBean;
import com.latyshonak.service.beans.UsersBean;
import com.latyshonak.service.beans.security.GrantedAuthorityBean;
import com.latyshonak.service.beans.security.LoggedAccountBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CustomAuthenticationProvider implements AuthenticationProvider, CustomProvider {

	@Autowired
	private UsersService userService;


	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException{
 		createLoggedAccount(authentication);
		LoggedAccountBean loggedAccount = createLoggedAccount(authentication);
		String password = (String) authentication.getCredentials();

		if (!password.equals(loggedAccount.getPassword())) {
			throw new BadCredentialsException("Wrong password");
		}
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loggedAccount, password, loggedAccount.getAuthorities());
		return new UsernamePasswordAuthenticationToken(loggedAccount, password, loggedAccount.getAuthorities());
	}

	@Override
	public void authenticate(String email) {
		LoggedAccountBean loggedAccount = createLoggedAccount(email);
		SecurityContextHolder.getContext().setAuthentication( new UsernamePasswordAuthenticationToken(loggedAccount, loggedAccount.getPassword(), loggedAccount.getAuthorities()));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

	private LoggedAccountBean createLoggedAccount(Authentication authentication)  throws UsernameNotFoundException{
		try {
			UsersBean user = userService.getUserByEmail(authentication.getName());
			List<RoleBean> roles = user.getRoles();
			Collection<GrantedAuthorityBean> authorities = getUserAuthorities(roles);

			LoggedAccountBean loggedAccount = new LoggedAccountBean(user, authorities);

			return loggedAccount;
			}
			catch (NullPointerException n) {
				throw new UsernameNotFoundException("Email not found");
			}
	}

	private LoggedAccountBean createLoggedAccount(String email) {
		UsersBean user = userService.getUserByEmail(email);
		List<RoleBean> roles = user.getRoles();

		Collection<GrantedAuthorityBean> authorities = getUserAuthorities(roles);

		LoggedAccountBean loggedAccount = new LoggedAccountBean(user, authorities);

		return loggedAccount;
	}

	private Collection<GrantedAuthorityBean> getUserAuthorities(List<RoleBean> roles) {
		Collection<GrantedAuthorityBean> authorities = new ArrayList<>();

		for (RoleBean role : roles) {
			GrantedAuthorityBean bean = new GrantedAuthorityBean(role.getName());
			authorities.add(bean);
		}

		return authorities;
	}
}
