package com.jpa_project.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.PrenotazioneConfiguration;
import com.jpa_project.configuration.UtenteConfiguration;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Prenotazione;
import com.jpa_project.model.Utente;
import com.jpa_project.repository.PrenotazioneDaoRepository;

@Service
public class PrenotazioneService {

	@Autowired
	PrenotazioneDaoRepository repo;

	// CREA PRENOTAZIONE SE POSTAZIONE LIBERA PER UNA DETERMINATA DATA
	// E UTENTE LIBERO PER UNA DETERMINATA DATA

	public void creaPrenotazione(Postazione post, LocalDate data, Utente u) {

//		List<Prenotazione> lista = cercaPostazionePerData(data, u);
//		List<Prenotazione> listaPerUtente = cercaUtentePerData(data, u);
		if (cercaPostazionePerData(data, post) == 0 && cercaUtentePerData(data, u) == 0) {
			AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
					PrenotazioneConfiguration.class);
			Prenotazione p = (Prenotazione) appContext.getBean("nuovaPrenotazione");
			p.setPostazionePrenotata(post);
			p.setDataPrenotazione(data);
			p.setDataScadenza(data.plusDays(1));
			p.setUtente(u);
			salvaPrenotazione(p);
			System.out.println(
					"Prenotazione per l'edificio " + p.getPostazionePrenotata().getEdificio().getNome() + " accettata");
		} else if (cercaUtentePerData(data, u) > 0 && cercaPostazionePerData(data, post) > 0) {
			System.out.println(
					"L'utente " + u.getNome() + " " + u.getCognome() + " ha già prenotato la postazione dell'edificio "
							+ post.getEdificio().getNome() + " per la data " + data);
		} else if (cercaUtentePerData(data, u) > 0) {
			System.out.println("Utente già impegnato per la data " + data);
		} else {
			System.out.println("Postazione occupata per la data " + data);
		}
	}

	// CRUD

	public void salvaPrenotazione(Prenotazione p) {
		repo.save(p);
	}

	public Prenotazione cercaPrenotazioneById(Long id) {
		return repo.findById(id).get();
	}

	public void updatePrenotazione(Prenotazione p) {
		repo.save(p);
		System.out.println("Prenotazione modificata");
	}

	public void rimuoviPrenotazione(Prenotazione p) {
		repo.delete(p);
		System.out.println("Prenotazione eliminata");
	}

	public void rimuoviPrenotazionePerId(Long id) {
		repo.deleteById(id);
		System.out.println("Prenotazione eliminata");

	}

	public List<Prenotazione> cercaTuttePrenotazioni() {
		return repo.findAll();
	}



	// CERCA NUMERO POSTAZIONI PER DATA

	public int cercaPostazionePerData(LocalDate data, Postazione postazione) {
		return repo.checkPrenotazione(data, postazione).size();
	}
	
	// CERCA NUMERO PRENOTAZIONI UTENTE PER DATA
	
	public int cercaUtentePerData(LocalDate data, Utente utente) {
		return repo.checkPrenotazioniUtentePerData(data, utente).size();
	}
	
//	public List<Prenotazione> cercaPostazionePerData(LocalDate data, Postazione postazione) {
//	return repo.checkPrenotazione(data, postazione);
//}
	
//	public List<Prenotazione> cercaUtentePerData(LocalDate data, Utente utente) {
//	return repo.checkPrenotazioniUtentePerData(data, utente);
//}

}
