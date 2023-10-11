package com.bewise.pasantia.local.service.impl;

import com.bewise.pasantia.local.model.Venta;
import com.bewise.pasantia.local.repository.VentaRepository;
import com.bewise.pasantia.local.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;

    @Autowired
    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Venta crearVenta(Venta venta) {

        return ventaRepository.save(venta);
    }

    @Override
    public Venta actualizarVenta(Long id, Venta venta) {
        // Implementa la lógica de actualización si es necesaria.
        return null;
    }

    @Override
    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
