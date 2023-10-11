package com.bewise.pasantia.local.service;

import com.bewise.pasantia.local.model.Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProveedorService {
    List<Proveedor> listarProveedor();
    Proveedor obtenerProveedorPorId(Long id);
    Proveedor crearProveedor(Proveedor proveedor);
    Proveedor actualizarProveedor(Long id, Proveedor proveedor);
    void eliminarProveedor(Long id);
}
