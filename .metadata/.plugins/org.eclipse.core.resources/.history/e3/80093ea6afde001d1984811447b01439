package com.jpa_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.EdificioConfiguration;
import com.jpa_project.model.Edificio;
import com.jpa_project.repository.EdificioDaoRepository;


@Service
public class EdificioService {

	@Autowired private EdificioDaoRepository repo;
	
	// CREA EDIFICIO NEL DB
	
	public void creaEdificioNelDb() {
		AnnotationConfigApplicationContext appContext =
				new AnnotationConfigApplicationContext(EdificioConfiguration.class);
		Edificio e = (Edificio) appContext.getBean("nuovoEdificio");
		inserisciEdificio(e);
		System.out.println("Edificio " + e.getNome() + " creato correttamente");

	}
	
	// CRUD
	
	public void inserisciEdificio(Edificio e) {
		repo.save(e);
	}
	
	public Edificio cercaEdificioPerId(Long id) {
        return repo.findById(id).get();
    }
	
	public void updateEdificio(Edificio e) {
		repo.save(e);
		System.out.println("Edificio aggiornato correttamente");
	}
	
	public void eliminaEdificio(Edificio e) {
		repo.delete(e);
		System.out.println("Edificio eliminato");
	}
	
	public void eliminaEdificioPerId(Long id) {
		repo.deleteById(id);
		System.out.println("Edificio eliminato");
	}
	
	public List<Edificio> cercaTuttiEdifici(){
		return repo.findAll();
	}
}
