package com.evaluation.user.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigJwtService {
	
	private Environment environment;
	
	@Autowired
    public ConfigJwtService(Environment environment) {
        this.environment = environment;
    }
	
	public String getJwtSecret() {
    	return environment.getProperty("spring.jwt.secret");
    }
	
	public long getJwtExpiration() {
    	return Long.parseLong(environment.getProperty("spring.jwt.expiration"));
    }

}
