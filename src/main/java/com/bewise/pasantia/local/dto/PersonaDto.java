package com.bewise.pasantia.local.dto;

import com.bewise.pasantia.local.model.Local;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PersonaDto {
    private Long id;
    private String nombre;
    private double dinero;

    @ManyToOne
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

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
}

