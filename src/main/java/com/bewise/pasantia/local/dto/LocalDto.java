package com.bewise.pasantia.local.dto;


public class LocalDto {
    private Long id;
    private String nombre;
    private double patrimonio;
    private String proveedorNombre;

    // Getters y setters

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
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

    public String getProveedorNombre() {
        return proveedorNombre;
    }

    public void setProveedorNombre(String proveedorNombre) {
        this.proveedorNombre = proveedorNombre;
    }

    public LocalDto(Long id, String nombre, String proveedorNombre, double patrimonio) {
        this.id = id;
        this.nombre = nombre;
        this.proveedorNombre = proveedorNombre;
        this.patrimonio = patrimonio;
    }
}
