package com.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jpa_project.model.Utente;

@Repository
public interface UtenteDaoRepository extends JpaRepository<Utente, Long>, PagingAndSortingRepository<Utente, Long>{

	public boolean existsByEmail(String email);
}
