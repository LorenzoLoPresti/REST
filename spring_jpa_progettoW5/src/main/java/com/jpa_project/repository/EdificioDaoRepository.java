package com.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jpa_project.model.Edificio;

@Repository
public interface EdificioDaoRepository extends JpaRepository<Edificio, Long>, PagingAndSortingRepository<Edificio, Long> {

	public Edificio findEdificioByNome(String nome);
	public boolean existsByNome(String nome);
	
}
