package com.jpa_project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.jpa_project.model.Prenotazione;

@Configuration
public class PrenotazioneConfiguration {

	@Bean
	@Scope("prototype")
	public Prenotazione nuovaPrenotazione() {
		return new Prenotazione();
	}
}
