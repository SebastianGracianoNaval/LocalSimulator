package com.bewise.pasantia.local.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dia")
public class Dia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @Enumerated(EnumType.STRING)
   // private DiaEstado estado;

    @Column(name = "numero")
    private int numero;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    // Constructores, getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   // public DiaEstado getEstado() {
   //     return estado;
   // }

   // public void setEstado(DiaEstado estado) {
    //    this.estado = estado;
   // }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}

