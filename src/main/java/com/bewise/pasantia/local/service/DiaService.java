package com.bewise.pasantia.local.service;


import com.bewise.pasantia.local.model.Dia;

import java.util.List;

public interface DiaService {
    List<Dia> listarDias();
    Dia obtenerDiaPorId(Long id);
    Dia crearDia(Dia dia);
    Dia actualizarDia(Long id, Dia dia);
    void eliminarDia(Long id);
}


