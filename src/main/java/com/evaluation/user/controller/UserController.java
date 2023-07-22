package com.evaluation.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.user.regularExpressions.ConfigExpressions;
import com.evaluation.user.regularExpressions.Expressions;
import com.evaluation.user.responses.ErrorMessage;
import com.evaluation.user.responses.UserResponse;
import com.evaluation.user.security.JwtService;
import com.evaluation.user.service.UserService;
import com.evaluation.user.service.PhoneService;
import com.evaluation.user.entity.Phone;
import com.evaluation.user.entity.User;

@RestController 
@RequestMapping("/users")
public class UserController {
	
	private Expressions validator;
	
	@Autowired
    private JwtService jwtService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PhoneService phoneService;
	
	public UserController(ConfigExpressions config) {
		this.validator = new Expressions(config);
	}
	
	@PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User u) {
		try {
			//Verificar existencia de email
			if (userService.isEmailAlreadyRegistered(u.getEmail())) {
				String errorMessage = "El email ya está registrado";
	            return new ResponseEntity<>(new ErrorMessage(errorMessage), HttpStatus.BAD_REQUEST);
	        }
			
			//Validar contraseña
			if (!isValidPassword(u.getPassword())) {
	            String errorMessage = "La contraseña no cumple con las condiciones requeridas";
	            return new ResponseEntity<>(new ErrorMessage(errorMessage), HttpStatus.BAD_REQUEST);
	        }
			
			//Validar email
			if (!isValidEmail(u.getEmail())) {
	            String errorMessage = "El email no tiene un formato válido";
	            return new ResponseEntity<>(new ErrorMessage(errorMessage), HttpStatus.BAD_REQUEST);
	        }

			u.setToken(jwtService.generateToken(u.getEmail()));
			
			User savedUser = userService.save(u);
			
			for (Phone phone : u.getPhones()) {
	            phone.setUser(savedUser);
	            phoneService.save(phone);
	        }
			
			UserResponse userResponse = new  UserResponse(
					savedUser.getId(),
					savedUser.getCreated(),
					savedUser.getModified(),
					savedUser.getLast_login(),
					savedUser.getToken(),
					savedUser.isIsactive());
			
			return new ResponseEntity<>(userResponse, HttpStatus.OK);
		}catch(Exception e) {
			String errorMessage = "Ocurrio un error al crear el usuario";
            return new ResponseEntity<>(new ErrorMessage(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
    }
	
	@GetMapping("/list")
    public List<User> listUser() {
		return userService.listar();
    }
	
    public boolean isValidPassword(String password) {
        return validator.isValidPassword(password);
    }
    
    public boolean isValidEmail(String email) {
        return validator.isValidEmail(email);
    }

}
