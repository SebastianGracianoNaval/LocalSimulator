package com.bewise.pasantia.local.service.impl;

import com.bewise.pasantia.local.exceptions.LocalNotFoundException;
import com.bewise.pasantia.local.model.Local;
import com.bewise.pasantia.local.repository.LocalRepository;
import com.bewise.pasantia.local.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocalServiceImpl implements LocalService {
    private final LocalRepository localRepository;

    public LocalServiceImpl(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    public List<Local> listarLocales() {
        return localRepository.findAll();
    }

    @Override
    public Local obtenerLocalPorId(Long id) {
        return localRepository.findById(id).orElse(null);
    }

    @Override
    public Local crearLocal(Local local) {

        return localRepository.save(local);
    }

    @Override
    public Local actualizarLocal(Long id, Local local) {
        Local existeLocal = localRepository.findById(id).orElse(null); // USAR OPTIONAL
        if (existeLocal != null) {
            existeLocal.setNombre(local.getNombre());
            return localRepository.save(existeLocal);
        }
        return null;
    }

    @Override
    public void eliminarLocal(Long id) {
        Local local = localRepository.findById(id).orElse(null);
        if (local == null) {
            throw new LocalNotFoundException(id);
        }
        localRepository.deleteById(id);
    }

}