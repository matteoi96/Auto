package com.comdata.automobile.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comdata.automobile.dto.AutomobileDto;
import com.comdata.automobile.model.Automobile;
import com.comdata.automobile.service.AutomobileServiceImpl;

@RestController
public class AutomobileController {

		
	@Autowired
	private AutomobileServiceImpl automobileServiceImpl;
	
	@GetMapping("/pagina")
	public Page<Automobile> vediPagina(@RequestParam("pagina") int pagina){
		return automobileServiceImpl.getPagina(pagina);
	}
	@GetMapping("/visualizza")
	public List<Automobile> getAll(){
		return automobileServiceImpl.getAll();
	}
	
    @GetMapping("/add")
	public AutomobileDto add() {
		return automobileServiceImpl.add();
	}
	
	
	@PostMapping("/add")
	public AutomobileDto add(@Valid @RequestBody Automobile automobile) {
		return automobileServiceImpl.add(automobile);
		
	}
	
	@PutMapping("/update")
	public AutomobileDto update(@Valid @RequestBody Automobile automobile) {
		return automobileServiceImpl.update(automobile);
		
	}
	
	@DeleteMapping("/delete")
	public AutomobileDto delete(@RequestBody Automobile automobile) {
		return automobileServiceImpl.delete(automobile);
	}
	
	
	



	

	
	}
	
	

