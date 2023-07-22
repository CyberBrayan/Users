package com.evaluation.user.interfaces;

import org.springframework.data.repository.CrudRepository;
import com.evaluation.user.entity.User;

public interface InterfaceUser extends CrudRepository<User,Integer> {
	
	public User findByEmail(String email);

}
