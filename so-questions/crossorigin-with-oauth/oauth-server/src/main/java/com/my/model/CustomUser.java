package com.my.model;

import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	private String id;
	private String name;

	public CustomUser(final UserEntity userEntity) {
		super(userEntity.getEmailId(), userEntity.getPassword(), userEntity.getGrantedAuthoritiesList());
		this.id = userEntity.getId();
		this.name = userEntity.getName();
	}

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
}
