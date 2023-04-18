package com.jpa_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;

@Repository
public interface PostazioneDaoRepository extends JpaRepository<Postazione, Long> {

	public List<Postazione> findByTipo(Tipo tipo);
	public List<Postazione>  findByEdificio(Edificio e);
	
	@Query(value = "SELECT p FROM Postazione p WHERE p.tipo = :tipo AND p.edificio.citta = :citta")
	List<Postazione> cercaPostazionePerTipoECittà(Tipo tipo, String citta);
	
}
