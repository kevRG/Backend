package com.example.springb.controllers;

import com.example.springb.dto.CreateReporteRequest;
import com.example.springb.models.Reporte;
import com.example.springb.services.ReporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping
    public ResponseEntity<List<Reporte>> listarReportes() {
        return ResponseEntity.ok(reporteService.obtenerTodos());
    }

    /** Cola de reportes sin asignar, del primero al último en llegar. */
    @GetMapping("/pendientes")
    public ResponseEntity<List<Reporte>> listarPendientes() {
        return ResponseEntity.ok(reporteService.obtenerPendientes());
    }

    /** Atiende el reporte que lleva más tiempo esperando (lo saca de la cola). 404 si la cola está vacía. */
    @PostMapping("/pendientes/atender")
    public ResponseEntity<?> atenderSiguiente() {
        return reporteService.atenderSiguiente()
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("mensaje", "No hay reportes pendientes por atender")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtenerReporte(@PathVariable Long id) {
        return reporteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearReporte(@RequestBody CreateReporteRequest request) {
        try {
            Reporte creado = reporteService.crear(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", e.getMessage()));
        }
    }
}
