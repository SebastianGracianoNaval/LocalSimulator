package com.bewise.pasantia.local.controller;

import com.bewise.pasantia.local.dto.VentaDto;
import com.bewise.pasantia.local.model.*;
import com.bewise.pasantia.local.service.PersonaService;
import com.bewise.pasantia.local.service.ProductoService;
import com.bewise.pasantia.local.service.VentaService;
import com.bewise.pasantia.local.service.impl.DiaServiceImpl;
import com.bewise.pasantia.local.service.impl.LocalServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

    private final VentaService ventaService;
    private final PersonaService personaService;
    private final ProductoService productoService;
    private final LocalServiceImpl localService;

    private final DiaServiceImpl diaService;

    public VentaController(VentaService ventaService, PersonaService personaService, ProductoService productoService, LocalServiceImpl localService, DiaServiceImpl diaService) {
        this.ventaService = ventaService;
        this.personaService = personaService;
        this.productoService = productoService;
        this.localService = localService;
        this.diaService = diaService;
    }

    @GetMapping("/listar")
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Long id) {
        Venta venta = ventaService.obtenerVentaPorId(id);
        if (venta != null) {
            return new ResponseEntity<>(venta, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        Venta venta = ventaService.obtenerVentaPorId(id);
        if (venta != null) {
            ventaService.eliminarVenta(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/crear")
    public Venta crearVenta(@RequestBody VentaDto ventaDto) {
        Venta venta = convertirVentaDtoAVenta(ventaDto);
        return ventaService.crearVenta(venta);
    }

    // Método para convertir VentaDto a Venta
    private Venta convertirVentaDtoAVenta(VentaDto ventaDto) {
        Venta venta = new Venta();

        // Obtener la persona por su ID
        Persona persona = personaService.obtenerPersonaPorId(ventaDto.getPersonaId());
        if (persona != null) {
            venta.setPersona(persona);
        }

        // Obtener el producto por su ID
        Producto producto = productoService.obtenerProductoPorId(ventaDto.getProductoId());
        if (producto != null) {
            venta.setProducto(producto);
        }

        // Obtener el local por su ID
        Local local = localService.obtenerLocalPorId(ventaDto.getLocalId());
        if (local != null) {
            venta.setLocal(local);
        }

        // Obtener el día por su ID
        Dia dia = diaService.obtenerDiaPorId(ventaDto.getDiaId());
        if (dia != null) {
            venta.setDia(dia);
        }

        return venta;
    }

}

