package com.example.springb.services;

import com.example.springb.dto.CreateDepositoDTO;
import com.example.springb.models.Deposito;
import com.example.springb.structures.CustomLinkedList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DepositoService {
    private final CustomLinkedList<Deposito> depositos;
    private Long nextId = 1L;

    public DepositoService() {
        this.depositos = new CustomLinkedList<>();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        depositos.add(new Deposito(
                nextId++, "Tanque Elevado Norte", 50000.0, 42500.0,
                "Tanque Elevado", "Av. Tecnológico 120, Col. Centro",
                LocalDate.of(2023, 5, 14), "ACTIVO"
        ));
        depositos.add(new Deposito(
                nextId++, "Cisterna Subterránea Sur", 80000.0, 12000.0,
                "Cisterna", "Calle 16 de Septiembre 450, Col. La Paz",
                LocalDate.of(2022, 11, 20), "ALERTA_NIVEL_BAJO"
        ));
        depositos.add(new Deposito(
                nextId++, "Depósito Comunitario San Manuel", 35000.0, 29000.0,
                "Tinaco Industrial", "Blvd. Circunvalación 89, Col. San Manuel",
                LocalDate.of(2024, 2, 10), "ACTIVO"
        ));
    }

    public List<Deposito> obtenerTodos() {
        return depositos.toList();
    }

    public Optional<Deposito> obtenerPorId(Long id) {
        return depositos.toList().stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();
    }

    public Deposito crear(CreateDepositoDTO dto) {
        Deposito nuevo = new Deposito(
                nextId++,
                dto.getNombreDeposito(),
                dto.getCapacidadLitros(),
                dto.getNivelActualLitros(),
                dto.getTipoDeposito(),
                dto.getUbicacion(),
                dto.getFechaInstalacion() != null ? dto.getFechaInstalacion() : LocalDate.now(),
                dto.getEstado() != null ? dto.getEstado() : "ACTIVO"
        );
        depositos.add(nuevo);
        return nuevo;
    }
}