package com.bewise.pasantia.local.controller;

import com.bewise.pasantia.local.dto.DiaDto;
import com.bewise.pasantia.local.model.Dia;
import com.bewise.pasantia.local.model.DiaEstado;
import com.bewise.pasantia.local.model.Local;
import com.bewise.pasantia.local.service.LocalService;
import com.bewise.pasantia.local.service.DiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dias")
public class DiaController {

    @Autowired
    private DiaService diaService;
    private LocalService localService;

    @GetMapping("/")
    public List<Dia> listarDias() {
        return diaService.listarDias();
    }

    @GetMapping("/{id}")
    public Dia obtenerDia(@PathVariable Long id) {
        return diaService.obtenerDiaPorId(id);
    }

    @PostMapping("/")
    public Dia crearDia(@RequestBody DiaDto diaDto) {
        // Crear una instancia de Dia a partir de DiaDto
        Dia dia = new Dia();
        dia.setNumero(diaDto.getNumero());

        // Obtener el local al que pertenece el día
        Local local = localService.obtenerLocalPorId(diaDto.getLocalId());
        dia.setLocal(local);

        // Establecer el estado inicial (Abierto)
        dia.setEstado(DiaEstado.Abierto);

        // Guardar el día en la base de datos
        return diaService.crearDia(dia);
    }


    @PutMapping("/{id}")
    public Dia actualizarDia(@PathVariable Long id, @RequestBody Dia dia) {
        return diaService.actualizarDia(id, dia);
    }

    @DeleteMapping("/{id}")
    public void eliminarDia(@PathVariable Long id) {
        diaService.eliminarDia(id);
    }
}

