package com.bewise.pasantia.local.repository;

import com.bewise.pasantia.local.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {

}
