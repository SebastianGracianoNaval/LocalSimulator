package com.bewise.pasantia.local.service;

import com.bewise.pasantia.local.model.Venta;

import java.util.List;

public interface VentaService {

    List<Venta> listarVentas();

    Venta obtenerVentaPorId(Long id);

    Venta crearVenta(Venta venta);

    Venta actualizarVenta(Long id, Venta venta);

    void eliminarVenta(Long id);
}

