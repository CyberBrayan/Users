package com.evaluation.user.interfaceService;

import java.util.List;
import java.util.Optional;

import com.evaluation.user.entity.User;

public interface IUserService {
	
	public List<User> getAllUsers();
	public Optional<User> listarId();
	public User saveUser(User u);
	public void delete(int id);

}
