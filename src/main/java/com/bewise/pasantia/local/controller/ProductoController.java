package com.bewise.pasantia.local.controller;


import com.bewise.pasantia.local.model.Producto;
import com.bewise.pasantia.local.service.impl.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping("")
    public List<Producto> getAllProductos() {
        return productoService.listarProducto();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoService.obtenerProductoPorId(id);
    }

    @PostMapping("")
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto updatedProducto) {
        return productoService.actualizarProducto(id, updatedProducto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

}
