package com.bewise.pasantia.local.controller;

import com.bewise.pasantia.local.dto.ProveedorDto;
import com.bewise.pasantia.local.model.Proveedor;
import com.bewise.pasantia.local.service.impl.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorServiceImpl proveedorService;

    @GetMapping("")
    public List<Proveedor> getAllProveedor() {
        return proveedorService.listarProveedor();
    }

    @GetMapping("/{id}")
    public Proveedor getProveedorById(@PathVariable Long id) {
        Proveedor proveedor = proveedorService.obtenerProveedorPorId(id);
        if (proveedor == null) {
            // Manejo de errores
            return null; // ResponseEntity con un mensaje de error
        }
        return proveedor;
    }


    @PostMapping("")
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.crearProveedor(proveedor);
    }

    @PutMapping("/{id}")
    public Proveedor updateProveedor(@PathVariable Long id, @RequestBody Proveedor updatedProveedor) {
        return proveedorService.actualizarProveedor(id, updatedProveedor);
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
    }
}
