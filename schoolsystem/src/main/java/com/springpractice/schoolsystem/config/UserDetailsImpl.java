package com.springpractice.schoolsystem.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springpractice.schoolsystem.entities.User;

public class UserDetailsImpl implements UserDetails {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -1594299839567196445L;
	
	private User user;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		GrantedAuthority gAuthority = new SimpleGrantedAuthority("ROLE" + this.user.getRole());
		grantedAuthorities.add(gAuthority);
		
		return grantedAuthorities;
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

		return false;
	}

	@Override
	public boolean isAccountNonLocked() {

		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return false;
	}

	@Override
	public boolean isEnabled() {

		return false;
	}

}
