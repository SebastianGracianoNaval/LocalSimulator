package com.bewise.pasantia.local.service.impl;


import com.bewise.pasantia.local.model.Producto;
import com.bewise.pasantia.local.repository.ProductoRepository;
import com.bewise.pasantia.local.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;


    public ProductoServiceImpl(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }


    @Override
    public List<Producto> listarProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        Producto existeProducto = productoRepository.findById(id).orElse(null);
        if(existeProducto != null){
            existeProducto.setNombre(producto.getNombre());
            return productoRepository.save(existeProducto);
        }
        return null;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);

    }
}
