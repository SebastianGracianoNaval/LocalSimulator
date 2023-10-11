package com.bewise.pasantia.local.service;

import com.bewise.pasantia.local.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {
    List<Producto> listarProducto();
    Producto obtenerProductoPorId(Long id);
    Producto crearProducto(Producto producto);
    Producto actualizarProducto(Long id, Producto producto);
    void eliminarProducto(Long id);
}
