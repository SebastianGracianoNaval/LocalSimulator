package com.bewise.pasantia.local.service.impl;

import com.bewise.pasantia.local.model.*;
import com.bewise.pasantia.local.repository.*;
import com.bewise.pasantia.local.service.DiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaServiceImpl implements DiaService {

    @Autowired
    private DiaRepository diaRepository;

    @Override
    public List<Dia> listarDias() {
        return diaRepository.findAll();
    }

    @Override
    public Dia obtenerDiaPorId(Long id) {
        return diaRepository.findById(id).orElse(null);
    }

    @Override
    public Dia crearDia(Dia dia) {
        return diaRepository.save(dia);
    }

    @Override
    public Dia actualizarDia(Long id, Dia dia) {
        Dia existeDia = diaRepository.findById(id).orElse(null);
        if (existeDia != null) {
            return diaRepository.save(existeDia);
        }
        return null;
    }

    @Override
    public void eliminarDia(Long id) {
        diaRepository.deleteById(id);
    }
}


