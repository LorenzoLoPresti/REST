package com.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa_project.model.Edificio;

@Repository
public interface EdificioDaoRepository extends JpaRepository<Edificio, Long> {


}
