package com.bewise.pasantia.local.dto;

import com.bewise.pasantia.local.model.Local;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class ProveedorDto {
    private Long id;
    private String nombre;
    private String cantidadProducto;

    @OneToMany
    @JoinColumn(name = "local_id")
    private Local local;


// Getters y setters

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
}

