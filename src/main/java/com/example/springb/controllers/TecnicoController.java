package com.example.springb.controllers;

import com.example.springb.dto.CreateTecnicoDTO;
import com.example.springb.models.Tecnico;
import com.example.springb.services.TecnicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @GetMapping
    public ResponseEntity<List<Tecnico>> listarTecnicos() {
        return ResponseEntity.ok(tecnicoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> obtenerTecnico(@PathVariable Long id) {
        return tecnicoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tecnico> crearTecnico(@RequestBody CreateTecnicoDTO dto) {
        Tecnico creado = tecnicoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}