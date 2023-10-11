package com.bewise.pasantia.local.repository;

import com.bewise.pasantia.local.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
