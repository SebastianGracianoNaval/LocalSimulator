package com.bewise.pasantia.local.repository;

import com.bewise.pasantia.local.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
