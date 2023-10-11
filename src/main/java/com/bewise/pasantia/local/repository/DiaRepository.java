package com.bewise.pasantia.local.repository;

import com.bewise.pasantia.local.model.Dia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {
}

