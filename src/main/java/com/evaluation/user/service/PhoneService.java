package com.evaluation.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.user.entity.Phone;
import com.evaluation.user.interfaceService.IPhoneService;
import com.evaluation.user.interfaces.InterfacePhone;

@Service
public class PhoneService implements IPhoneService {
	
	@Autowired
	private InterfacePhone iPhone;

	@Override
	public List<Phone> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Phone> listarId() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Phone savePhone(Phone u) {
		return iPhone.save(u);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
