package com.jpa_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.EdificioConfiguration;
import com.jpa_project.model.Edificio;
import com.jpa_project.repository.EdificioDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class EdificioService {

	@Autowired private EdificioDaoRepository repo;
	
	// CREA EDIFICIO NEL DB
	
	public Edificio creaEdificioNelDb() {
		AnnotationConfigApplicationContext appContext =
				new AnnotationConfigApplicationContext(EdificioConfiguration.class);
		Edificio e = (Edificio) appContext.getBean("nuovoEdificio");
		inserisciEdificio(e);
		System.out.println("Edificio " + e.getNome() + " creato correttamente");
		return e;

	}
	
	// CRUD
	
	public Edificio inserisciEdificio(Edificio e) {
		if(repo.existsById(e.getId())) {	
			throw new EntityExistsException("Edificio già esistente");
		}
		repo.save(e);
		return e;
	}
	
	public Edificio cercaEdificioPerId(Long id) {
		if(!repo.existsById(id)) {	
			throw new EntityNotFoundException("L'edificio non esiste");
		}
        return repo.findById(id).get();
    }
	
	public Edificio cercaEdificioPerNome(String nome) {
//		if(!repo.existsById(id)) {	
//			throw new EntityNotFoundException("L'edificio non esiste");
//		}
        return repo.findEdificioByNome(nome);
    }
	
	public Edificio updateEdificio(Edificio e) {
		if(!repo.existsById(e.getId())) {
			throw new EntityNotFoundException("L'edificio non esiste");
		}
		repo.save(e);
		System.out.println("Edificio aggiornato correttamente");
		return e;
	}
	
	public void eliminaEdificio(Edificio e) {
		if(!repo.existsById(e.getId())) {
			throw new EntityNotFoundException("L'edificio non esiste");
		}
		repo.delete(e);
		System.out.println("Edificio eliminato");
	}
	
	public void eliminaEdificioPerId(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("L'edificio non esiste");
		}
		repo.deleteById(id);
		System.out.println("Edificio eliminato");
	}
	
	public List<Edificio> cercaTuttiEdifici(){
		return repo.findAll();
	}
}
