package com.bewise.pasantia.local.service.impl;

import com.bewise.pasantia.local.model.Proveedor;
import com.bewise.pasantia.local.repository.ProveedorRepository;
import com.bewise.pasantia.local.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private ProveedorRepository proveedorRepository;


    public ProveedorServiceImpl (ProveedorRepository proveedorRepository){
        this.proveedorRepository = proveedorRepository;
    }
    @Override
    public List<Proveedor> listarProveedor() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor actualizarProveedor(Long id, Proveedor proveedor) {
        Proveedor existeProveedor = proveedorRepository.findById(id).orElse(null);
        if(existeProveedor != null){
            existeProveedor.setNombre(proveedor.getNombre());
            return proveedorRepository.save(existeProveedor);
        }
        return null;
    }

    @Override
    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);

    }
}
