package com.jpa_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.PostazioneConfiguration;
import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;
import com.jpa_project.repository.PostazioneDaoRepository;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneDaoRepository repo;

	//CREA POSTAZIONE
	
	public void creaPostazione(String desc, Edificio e, Tipo t) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				PostazioneConfiguration.class);
		Postazione p = (Postazione) appContext.getBean("creaPostazione");
		p.setDescrizione(desc);
		p.setEdificio(e);
		p.setTipo(t);
		p.creaOccupanti(p);

		System.out.println("prima");
		inserisciPostazione(p);
		System.out.println("dopo");
		System.out.println("Postazione " + p.getTipo() + " dell'edificio "
		+ p.getEdificio().getNome() + " creata correttamente");
	}
	
	// CRUD

	public void inserisciPostazione(Postazione p) {
		repo.save(p);
	}

	public Postazione cercaPostazionePerId(Long id) {
		return repo.findById(id).get();
	}

	public void updatePostazione(Postazione p) {
		repo.save(p);
		System.out.println("Postazione modificata");
	}

	public void rimuoviPostazione(Postazione p) {
		repo.delete(p);
		System.out.println("Postazione rimossa");
	}

	public void rimuoviPostazionePerId(Long id) {
		repo.deleteById(id);
		System.out.println("Postazione rimossa");
	}

	public List<Postazione> cercaTuttePostazioni() {
		return repo.findAll();
	}
	
	// CERCA POSTAZIONE PER EDIFICIO

	public List<Postazione> cercaPostazionePerEdificio(Edificio ed) {
		return repo.findByEdificio(ed);
	}
	
	// CERCA POSTAZIONE PER TIPO E CITTA

	public List<Postazione> ricercaPostazione_tipo_città(Tipo tipo, String citta) {
		return repo.cercaPostazionePerTipoECittà(tipo, citta);
	}
}
