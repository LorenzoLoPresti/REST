package com.jpa_project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;

@Configuration
public class PostazioneConfiguration {
	
	@Bean
	@Scope("prototype")
	public Postazione creaPostazione() {
		return new Postazione();
	}
}
