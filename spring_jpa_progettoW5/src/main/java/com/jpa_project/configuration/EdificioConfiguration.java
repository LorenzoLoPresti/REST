package com.jpa_project.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;
import com.jpa_project.model.Edificio;

@Configuration
public class EdificioConfiguration {

	@Bean
	public Edificio nuovoEdificio() {
		Edificio e = new Edificio();
		Faker fake = Faker.instance(new Locale("it-IT"));
		e.setCitta(fake.address().city());
		e.setNome(fake.name().nameWithMiddle() + " building");
		e.setIndirizzo(fake.address().streetName());
		
		return e;
	}
}
