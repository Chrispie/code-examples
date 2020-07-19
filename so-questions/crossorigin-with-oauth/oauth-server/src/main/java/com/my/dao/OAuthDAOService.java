package com.my.dao;


import com.my.model.UserEntity;

public interface OAuthDAOService {

	public UserEntity getUserDetails(String emailId);
}
