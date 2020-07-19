package com.my.dao;

import com.my.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class OAuthDAOServiceImpl implements OAuthDAOService {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public UserEntity getUserDetails(final String emailId) {

        //Created a hardcoded user and return it straight forward for demo purposes
        final Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        grantedAuthoritiesList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE1";
            }
        });

        final UserEntity userEntity = new UserEntity();
        userEntity.setId("DUMMY_USER");
        userEntity.setEmailId(emailId);
        userEntity.setName("DUMMY");
        userEntity.setId(emailId);
        userEntity.setPassword("$2a$10$R.enOqfTkR4PYAchKHExKevxiTmJvQzZ3u1uB7q4pJEWolwyfzRTa");//password

        return userEntity;
    }

}
