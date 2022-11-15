package com.comdata.automobile.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.comdata.automobile.dto.AutomobileDto;
import com.comdata.automobile.model.Automobile;
import com.comdata.automobile.repository.AutomobileRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AutomobileServiceImpl implements AutomobileService {

	@Autowired
	private AutomobileRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Automobile> getAll() {
		return (List<Automobile>) repository.findAll();

	}

	@Override
	public AutomobileDto add() {

		try {
			log.info("Automobile di default");
			Automobile automobile = new Automobile("Fiat", "abcde");
			repository.save(automobile);
			return autoToDTO(automobile);

		} catch (Exception e) {
			log.error("Validazione errata");

			return null;
		}
	}

	@Override
	public AutomobileDto add(Automobile automobile) {

		try {
			log.info("Aggiungi auto ");
			repository.save(automobile);
			return autoToDTO(automobile);
		} catch (Exception e) {
			log.error("Validazione errata");
			return null;
		}
	}

	@Override
	public AutomobileDto update(Automobile automobile) {

		try {
			log.info("Modifica auto ");
			repository.save(automobile);
			return autoToDTO(automobile);
		} catch (Exception e) {
			log.error("Validazione errata");
			return null;
		}
	}

	@Override
	public AutomobileDto delete(Automobile automobile) {
		try {
			log.info("Elimina auto ");
			repository.delete(automobile);
			return autoToDTO(automobile);
		} catch (Exception e) {
			log.error("validazione errata");

			return null;
		}

	}

	@Override
	public AutomobileDto autoToDTO(Automobile automobile) {
		AutomobileDto autoDTO = this.modelMapper.map(automobile, AutomobileDto.class);
		return autoDTO;
	}
	
	public Page<Automobile> getPagina(int pagina){
        try {
            return repository.findAll(PageRequest.of(pagina, 5));
        }catch (Exception e) {
            return null;
        }
        
    }

}
