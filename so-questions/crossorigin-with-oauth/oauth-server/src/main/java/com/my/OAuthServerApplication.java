package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class OAuthServerApplication {
	public static void main(final String[] args) {
		SpringApplication.run(OAuthServerApplication.class, args);
	}
}