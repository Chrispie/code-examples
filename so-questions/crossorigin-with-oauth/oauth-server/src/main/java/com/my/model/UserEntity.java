package com.my.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class UserEntity {

	private String id;
	private String name;
	private String emailId;
	private String password;
	private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(final String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}
	public Collection<GrantedAuthority> getGrantedAuthoritiesList() {
		return grantedAuthoritiesList;
	}
	public void setGrantedAuthoritiesList(final Collection<GrantedAuthority> grantedAuthoritiesList) {
		this.grantedAuthoritiesList = grantedAuthoritiesList;
	}
}
