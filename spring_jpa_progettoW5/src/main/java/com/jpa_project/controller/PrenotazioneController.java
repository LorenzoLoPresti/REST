package com.jpa_project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Prenotazione;
import com.jpa_project.model.Utente;
import com.jpa_project.service.PostazioneService;
import com.jpa_project.service.PrenotazioneService;
import com.jpa_project.service.UtenteService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

	@Autowired PrenotazioneService prenotazioneService;
	@Autowired UtenteService utenteService;
	@Autowired PostazioneService postazioneService;
	
//	@GetMapping
//	public ResponseEntity<List<Prenotazione>> getPrenotazioni(){
//		return new ResponseEntity<List<Prenotazione>>(prenotazioneService.cercaTuttePrenotazioni(), HttpStatus.OK);
//	}
//	
	@GetMapping
	public ResponseEntity<?> getPrenotazioni(Pageable page){
		return new ResponseEntity<>(prenotazioneService.cercaTuttePrenotazioniPaginate(page), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Prenotazione> getPrenotazioniPerId(@PathVariable Long id){
		return new ResponseEntity<Prenotazione>(prenotazioneService.cercaPrenotazioneById(id), HttpStatus.OK);
	}
	
	@PostMapping("/custom")
	public ResponseEntity<?> aggiungiPrenotazioneAuto(@RequestParam(value = "id_postazione") Long idPostazione
			, @RequestParam(value = "data") LocalDate data
			, @RequestParam(value = "id_utente") Long idUtente)
	{
		Postazione post = postazioneService.cercaPostazionePerId(idPostazione);
		Utente u = utenteService.cercaUtentePerId(idUtente);
		Prenotazione p = prenotazioneService.creaPrenotazione(post, data, u);
		return new ResponseEntity<>(prenotazioneService.salvaPrenotazione(p), HttpStatus.CREATED);
	}
	
	@PostMapping()
	public ResponseEntity<?> aggiungiPrenotazione(@RequestBody Prenotazione p){
		return new ResponseEntity<>(prenotazioneService.salvaPrenotazione(p), HttpStatus.CREATED);
	}
	
//	@PostMapping
//	public ResponseEntity<?> aggiungiEdificio(@RequestBody Edificio e){
//		Edificio f = edificioService.inserisciEdificio(e);
//		return new ResponseEntity<>(f, HttpStatus.CREATED);
//	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaEdificioPerId(@PathVariable Long id){
		return new ResponseEntity<>(prenotazioneService.rimuoviPrenotazionePerId(id), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> modificaEdificio(@RequestBody Prenotazione p){
		
		return new ResponseEntity<>(prenotazioneService.updatePrenotazione(p), HttpStatus.OK);
	}
}
