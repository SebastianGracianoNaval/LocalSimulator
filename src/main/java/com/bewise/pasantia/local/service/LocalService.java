package com.bewise.pasantia.local.service;

import com.bewise.pasantia.local.model.Local;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface LocalService {
    List<Local> listarLocales();
    Local obtenerLocalPorId(Long id);
    Local crearLocal(Local local);
    Local actualizarLocal(Long id, Local local);
    void eliminarLocal(Long id);
}


