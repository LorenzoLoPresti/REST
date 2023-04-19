package com.jpa_project.controller;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa_project.configuration.EdificioConfiguration;
import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;
import com.jpa_project.service.EdificioService;
import com.jpa_project.service.PostazioneService;

@RestController
@RequestMapping("/postazione")
public class PostazioneController {

	@Autowired PostazioneService postazioneService;
	@Autowired EdificioService edificioService;
	@Autowired ObjectProvider<Edificio> objEdificio;
	
	@PostMapping
	public ResponseEntity<?> nuovaPostazione(@RequestBody Postazione post, @RequestParam(value = "nomeEdificio") String nome){
		
		post.setEdificio(edificioService.cercaEdificioPerNome(nome));
		
		return new ResponseEntity<>(postazioneService.inserisciPostazione(post), HttpStatus.CREATED);
	}
}