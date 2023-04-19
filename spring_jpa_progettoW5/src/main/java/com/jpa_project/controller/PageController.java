package com.jpa_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jpa_project.model.Edificio;
import com.jpa_project.model.Info;
import com.jpa_project.model.Utente;
import com.jpa_project.service.EdificioService;
import com.jpa_project.service.PostazioneService;
import com.jpa_project.service.UtenteService;

@Controller
public class PageController {
	
	@Autowired UtenteService utenteService;
	@Autowired PostazioneService postazioneService;
	@Autowired EdificioService edificioService;

	@GetMapping("/homepage")
	public @ResponseBody String getHomepage() {
		return "Benvenuto";
	}
	
	@GetMapping("/info/{lingua}")
	public ModelAndView info(@PathVariable String lingua) {
		Info informazioni = new Info(lingua);
		ModelAndView model = new ModelAndView("info");
		model.addObject("messaggio", informazioni.getMessaggio());
		return model;
	}
	
//	@GetMapping(value="/edificio/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
////	@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
//	public ResponseEntity<Edificio> edificiPerId(@PathVariable Long id) {
//		Edificio e = edificioService.cercaEdificioPerId(id);
//		
//		ResponseEntity<Edificio> resp = new ResponseEntity<Edificio>(e, HttpStatus.OK);
//		return resp;
//	}
//	
//	@GetMapping(value="/edificio", produces = MediaType.APPLICATION_JSON_VALUE)
////	@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
//	public ResponseEntity<?> edifici() {
//		List<Edificio> e = edificioService.cercaTuttiEdifici();
//		
//		ResponseEntity<List<Edificio>> resp = new ResponseEntity<List<Edificio>>(e, HttpStatus.OK);
//		return resp;
//	}
	
//	@GetMapping(value="/utenti", produces = MediaType.APPLICATION_JSON_VALUE)
////	@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
//	public ResponseEntity<?> utenti() {
//		List<Utente> e = utenteService.cercaTuttiGliUtenti();
//		
//		ResponseEntity<List<Utente>> resp = new ResponseEntity<List<Utente>>(e, HttpStatus.OK);
//		return resp;
//	}
}
