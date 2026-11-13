package com.example.springb.controllers;

import com.example.springb.dto.CreateDepositoDTO;
import com.example.springb.models.Deposito;
import com.example.springb.services.DepositoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/depositos")
public class DepositoController {

    private final DepositoService depositoService;

    public DepositoController(DepositoService depositoService) {
        this.depositoService = depositoService;
    }

    @GetMapping
    public ResponseEntity<List<Deposito>> listarDepositos() {
        return ResponseEntity.ok(depositoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deposito> obtenerDeposito(@PathVariable Long id) {
        return depositoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Deposito> crearDeposito(@RequestBody CreateDepositoDTO dto) {
        Deposito creado = depositoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}