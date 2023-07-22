package com.evaluation.user.regularExpressions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigExpressions {
	
	private Environment environment;
	
	@Autowired
    public ConfigExpressions(Environment environment) {
        this.environment = environment;
    }
	
    public String getExpression() {
    	return environment.getProperty("spring.password.nisum");
    }
	

}
