package com.jpa_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.UtenteConfiguration;
import com.jpa_project.model.Prenotazione;
import com.jpa_project.model.Utente;
import com.jpa_project.repository.UtenteDaoRepository;

@Service
public class UtenteService {

	@Autowired UtenteDaoRepository repo;
	;
	
	// CREA UTENTE NEL DB
	
	public void creaUtente() {
		 AnnotationConfigApplicationContext appContext =
				 new AnnotationConfigApplicationContext(UtenteConfiguration.class);
		Utente u = (Utente) appContext.getBean("nuovoUtente");
		inserisciUtente(u);
		System.out.println("Utente " + u.getNome() + " " + u.getCognome() + " creato correttamente");
	}
	
	// CRUD
	
	public void inserisciUtente(Utente u) {
		repo.save(u);
	}
	
	public Utente cercaUtentePerId(Long id) {
		return repo.findById(id).get();
	}
	
	public void updateUtente(Utente u) {
		repo.save(u);
		System.out.println("Utente modificato");
	}

	public void rimuoviUtente(Utente u) {
		repo.delete(u);
		System.out.println("Utente rimosso");
	}

	public void rimuoviUtentePerId(Long id) {
		repo.deleteById(id);
		System.out.println("Utente rimosso");
	}

	public List<Utente> cercaTuttiGliUtenti() {
		return repo.findAll();
	}
}
