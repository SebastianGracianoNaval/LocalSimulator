package com.bewise.pasantia.local.controller;

import com.bewise.pasantia.local.model.Dia;
import com.bewise.pasantia.local.service.DiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dias")
public class DiaController {

    @Autowired
    private DiaService diaService;

    @GetMapping("/")
    public List<Dia> listarDias() {
        return diaService.listarDias();
    }

    @GetMapping("/{id}")
    public Dia obtenerDia(@PathVariable Long id) {
        return diaService.obtenerDiaPorId(id);
    }

    @PostMapping("/")
    public Dia crearDia(@RequestBody Dia dia) {
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

