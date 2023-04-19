package com.jpa_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa_project.model.Edificio;
import com.jpa_project.service.EdificioService;

@RestController
@RequestMapping("/edificio")
public class EdificioController {
	
	@Autowired EdificioService edificioService;

	@GetMapping
	public ResponseEntity<List<Edificio>> getEdifici(){
		return new ResponseEntity<List<Edificio>>(edificioService.cercaTuttiEdifici(), HttpStatus.OK);
	}
	
	
}
