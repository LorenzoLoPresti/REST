package com.jpa_project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postazioni")
public class Postazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descrizione;
	@Enumerated(value = EnumType.STRING)
	private Tipo tipo;
	private int maxOccupanti;
	@OneToOne
	private Edificio edificio;
	@OneToMany(mappedBy = "postazionePrenotata")
	private List<Prenotazione> listaPrenotazioni;
	
	
	public Postazione(String descrizione, Tipo tipo, Edificio edificio) {
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.edificio = edificio;
	}
	
	public void creaOccupanti(Postazione p) {
		switch(p.getTipo()) {
		case PRIVATO:
			p.setMaxOccupanti(120);;
			break;
		
		case OPENSPACE:
			p.setMaxOccupanti(200);
			break;
		
		case SALA_RIUNIONI:
			p.setMaxOccupanti(60);
			break;
		
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "Postazione [id=" + id + ", descrizione=" + descrizione + ", tipo=" + tipo + ", maxOccupanti="
				+ maxOccupanti + ", edificio=" + edificio + "]";
	}
	
	
}
