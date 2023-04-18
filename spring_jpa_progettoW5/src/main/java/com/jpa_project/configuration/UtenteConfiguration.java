package com.jpa_project.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.jpa_project.model.Utente;

@Configuration
public class UtenteConfiguration {

	@Bean
	@Scope("prototype")
	public Utente nuovoUtente() {
		Utente u = new Utente();
		Faker fake = Faker.instance(new Locale("it-IT"));
		u.setNome(fake.name().firstName());
		u.setCognome(fake.name().lastName());
		u.setUsername(fake.name().username());
		u.setEmail(u.getNome().toLowerCase() + "." + u.getCognome().toLowerCase() + "@ex.com");
		
		return u;
	}
}
