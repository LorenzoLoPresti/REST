package com.jpa_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.PostazioneConfiguration;
import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;
import com.jpa_project.repository.PostazioneDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneDaoRepository repo;

	//CREA POSTAZIONE
	
	public Postazione creaPostazione(String desc, Edificio e, Tipo t) {
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
		return p;
	}
	
	// CRUD

	public Postazione inserisciPostazione(Postazione p) {
		if(repo.existsByEdificio(p.getEdificio())) {
			throw new EntityExistsException("Postazione già esistente");
		}
		repo.save(p);
		return p;
	}

	public Postazione cercaPostazionePerId(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("L'edificio non esiste");
		}
		return repo.findById(id).get();
	}

	public Postazione updatePostazione(Postazione p) {
		if(!repo.existsById(p.getId())) {
			throw new EntityExistsException("Postazione non esistente");
		}
		repo.save(p);
		System.out.println("Postazione modificata");
		return p;
	}

	public String rimuoviPostazione(Postazione p) {
		if(!repo.existsById(p.getId())) {
			throw new EntityExistsException("Postazione non esistente");
		}
		repo.delete(p);
		System.out.println("Postazione rimossa");
		return "Postazione rimossa";
	}

	public String rimuoviPostazionePerId(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Postazione non esistente");
		}
		repo.deleteById(id);
		System.out.println("Postazione rimossa");
		return "Postazione rimossa";
	}

	public List<Postazione> cercaTuttePostazioni() {
		return repo.findAll();
	}
	
	public Page<Postazione> cercaTuttePostazioniPaginate(Pageable page) {
		return repo.findAll(page);
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
