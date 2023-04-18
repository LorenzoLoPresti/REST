package com.jpa_project.runner;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.SystemPropertyUtils;

import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Prenotazione;
import com.jpa_project.model.Tipo;
import com.jpa_project.model.Utente;
import com.jpa_project.service.EdificioService;
import com.jpa_project.service.PostazioneService;
import com.jpa_project.service.PrenotazioneService;
import com.jpa_project.service.UtenteService;

@Component
public class AppRunner implements CommandLineRunner {

	@Autowired
	private PostazioneService postazioneService;
	@Autowired
	private EdificioService edificioService;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private PrenotazioneService prenotazioneService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run...");

		// EDIFICIO
		
		// creo edificio nel db
		// edificioService.creaEdificioNelDb();
		
		// leggo edificio dal db
		Edificio edificioLetto = edificioService.cercaEdificioPerId(1l);
		Edificio edificioLetto2 = edificioService.cercaEdificioPerId(2l);
		
        System.out.println(edificioLetto);

        // update edificio nel db
        edificioLetto.setCitta("Roma");
        edificioService.updateEdificio(edificioLetto);
        
        // elimino edificio dal db
        // edificioService.eliminaEdificio(edificioLetto);
  

		// POSTAZIONI
        
        // creo postazione nel db
        // postazioneService.creaPostazione("Grande sala per grande conferenza", edificioLetto, Tipo.OPENSPACE);

        // leggo postazione dal db
		Postazione postazioneLetta = postazioneService.cercaPostazionePerId(1l);
		System.out.println(postazioneLetta);
		
		// cerco postazione per tipo e città
//		List<Postazione> listaPostazione = postazioneService.ricercaPostazione_tipo_città(Tipo.OPENSPACE, "Roma");
//		listaPostazione.forEach(e -> System.out.println(e));
		
		// cerco postazione per edificio
		List<Postazione> listaPostazionePerEd = postazioneService.cercaPostazionePerEdificio(edificioLetto);

		// modifico Postazione
//		postazioneLetta.setEdificio(edificioLetto2);
//		postazioneService.updatePostazione(postazioneLetta);
		
		// elimino postazione
		//postazioneService.rimuoviPostazione(postazioneLetta);
		
		// UTENTI
		// crea utente nel db
		// utenteService.creaUtente();

		// leggi utente dal db
		Utente utenteLetto = utenteService.cercaUtentePerId(1l);
		System.out.println(utenteLetto);
		
		// trova tutti gli utenti
		// List<Utente> listaUtenti = utenteService.cercaTuttiGliUtenti();
		// utenteService.cercaTuttiGliUtenti().forEach(e -> System.out.println(e));

		// modifica utente
		utenteLetto.setNome("Andrea");
		utenteService.updateUtente(utenteLetto);
		System.out.println(utenteLetto);
		
		// elimina utente
		utenteService.rimuoviUtentePerId(2l);
		
		
		// PRENOTAZIONI
		
		// crea prenotazione
//		prenotazioneService.creaPrenotazione(postazioneLetta, LocalDate.now(), utenteLetto);
		
		// leggi prenotazione
		Prenotazione prenotazione1 = prenotazioneService.cercaPrenotazioneById(1l);
		System.out.println(prenotazione1);
		
		// modifica prenotazione
//		prenotazione1.setDataPrenotazione(LocalDate.now().plusMonths(1));
//		prenotazioneService.updatePrenotazione(prenotazione1);
//		System.out.println(prenotazione1);
		
		// elimina prenotazione
//		prenotazioneService.rimuoviPrenotazionePerId(3l);
		
		// cerca tutte le prenotazioni
//		List<Prenotazione> listaPrenotazioni = prenotazioneService.cercaTuttePrenotazioni();
//		listaPrenotazioni.forEach(e -> System.out.println(e));
		
		// cerca postazione per edificio
//		List<Postazione> listEdifici = postazioneService.cercaPostazionePerEdificio(edificioLetto);
//		System.out.println(listEdifici.size());

		// cerca numero prenotazioni per una deteminata postazione in una determinata data
		// System.out.println(prenotazioneService.cercaPostazionePerData(prenotazione1.getDataPrenotazione(), postazioneLetta));	
		
	}

}
