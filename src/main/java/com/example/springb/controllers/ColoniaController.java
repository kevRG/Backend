package com.example.springb.controllers;

import com.example.springb.dto.CreateColoniaRequest;
import com.example.springb.models.Colonia;
import com.example.springb.services.ColoniaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/colonias")
public class ColoniaController {

    private final ColoniaService coloniaService;

    public ColoniaController(ColoniaService coloniaService) {
        this.coloniaService = coloniaService;
    }

    @GetMapping
    public ResponseEntity<List<Colonia>> listarColonias() {
        return ResponseEntity.ok(coloniaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colonia> obtenerColonia(@PathVariable Long id) {
        return coloniaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearColonia(@RequestBody CreateColoniaRequest request) {
        try {
            Colonia creada = coloniaService.crear(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(creada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("mensaje", e.getMessage()));
        }
    }
}
