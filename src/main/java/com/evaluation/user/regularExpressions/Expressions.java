package com.evaluation.user.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Expressions {
	
	private final ConfigExpressions config;
	
	public Expressions(ConfigExpressions config) {
		this.config = config;
	}
	
    public boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-_+=]).{8,16}$");
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
    
    public boolean isValidEmail(String email) {
	    String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
	    Pattern pattern = Pattern.compile(emailRegex);
	    Matcher matcher = pattern.matcher(email);

	    return matcher.matches();
	}

}
