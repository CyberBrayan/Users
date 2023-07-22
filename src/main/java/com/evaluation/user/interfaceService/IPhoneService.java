package com.evaluation.user.interfaceService;

import java.util.List;
import java.util.Optional;

import com.evaluation.user.entity.Phone;

public interface IPhoneService {
	
	public List<Phone> listar();
	public Optional<Phone> listarId();
	public Phone savePhone(Phone u);
	public void delete(int id);

}
