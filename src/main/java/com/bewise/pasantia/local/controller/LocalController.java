package com.bewise.pasantia.local.controller;

import com.bewise.pasantia.local.exceptions.LocalNotFoundException;
import com.bewise.pasantia.local.model.Local;
import com.bewise.pasantia.local.service.impl.LocalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalServiceImpl localService;

    @GetMapping("")
    public List<Local> getAllLocales() {
        return localService.listarLocales();
    }

    @GetMapping("/{id}")
    public Local getLocalById(@PathVariable Long id) {
        return localService.obtenerLocalPorId(id);
    }


    @PostMapping("")
    public Local createLocal(@RequestBody Local local) {
        return localService.crearLocal(local);
    }

    @PutMapping("/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local updatedLocal) {
        return localService.actualizarLocal(id, updatedLocal);
    }

    @DeleteMapping("/{id}")
    public void deleteLocal(@PathVariable Long id) {
        localService.eliminarLocal(id);
    }

    @ControllerAdvice
    public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(LocalNotFoundException.class)
        public ResponseEntity<Object> handleLocalNotFoundException(LocalNotFoundException ex) {
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("message", ex.getMessage());

            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }



}



