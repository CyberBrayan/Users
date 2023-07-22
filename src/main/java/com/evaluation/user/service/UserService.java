package com.evaluation.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.user.entity.User;
import com.evaluation.user.interfaceService.IUserService;
import com.evaluation.user.interfaces.InterfaceUser;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private InterfaceUser iUser;

	@Override
	public List<User> listar() {
		return  (List<User>)iUser.findAll();
	}

	@Override
	public Optional<User> listarId() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public User save(User u) {
		return iUser.save(u);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEmailAlreadyRegistered(String email) {
        User existingUser = iUser.findByEmail(email);
        return existingUser != null;
    }
	
	

}
