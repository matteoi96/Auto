package com.comdata.automobile.service;

import java.util.List;

import com.comdata.automobile.dto.AutomobileDto;
import com.comdata.automobile.model.Automobile;

public interface AutomobileService {
	
	
	public List<Automobile> getAll();
	
	public AutomobileDto add();
	
	public AutomobileDto add(Automobile automobile);
	
	public AutomobileDto update(Automobile automobile);
	
	public AutomobileDto delete(Automobile automobile);
	
	public AutomobileDto autoToDTO(Automobile automobile);


	
}
