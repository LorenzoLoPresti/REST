package com.jpa_project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa_project.model.Postazione;
import com.jpa_project.model.Prenotazione;
import com.jpa_project.model.Utente;

@Repository
public interface PrenotazioneDaoRepository extends JpaRepository<Prenotazione, Long> {

	@Query(value = "SELECT p FROM Prenotazione p WHERE :data BETWEEN p.dataPrenotazione AND p.dataScadenza"
			+ " AND p.postazionePrenotata = :postazione")
	List<Prenotazione> checkPrenotazione(LocalDate data, Postazione postazione);
	
	@Query(value = "SELECT p FROM Prenotazione p WHERE p.utente = :utente "
			+ "AND p.dataPrenotazione = :data")
	List<Prenotazione> checkPrenotazioniUtentePerData(LocalDate data, Utente utente);
	
}
