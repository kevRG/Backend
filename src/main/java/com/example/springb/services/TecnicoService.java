package com.example.springb.services;

import com.example.springb.dto.CreateTecnicoDTO;
import com.example.springb.models.Tecnico;
import com.example.springb.structures.CustomLinkedList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    private final CustomLinkedList<Tecnico> tecnicos;
    private Long nextId = 1L;

    public TecnicoService() {
        this.tecnicos = new CustomLinkedList<>();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        tecnicos.add(new Tecnico(
                nextId++, "Carlos", "Méndez Ríos", "2223014455", "carlos.mendez@aguaalerta.mx",
                "Reparación de tuberías hidráulicas", LocalDate.of(2022, 3, 15), "DISPONIBLE"
        ));
        tecnicos.add(new Tecnico(
                nextId++, "Laura", "Salazar Ortiz", "2224098877", "laura.salazar@aguaalerta.mx",
                "Sensores IoT y telemetría", LocalDate.of(2023, 8, 1), "EN_SERVICIO"
        ));
        tecnicos.add(new Tecnico(
                nextId++, "Roberto", "Castillo Peña", "2227123399", "roberto.castillo@aguaalerta.mx",
                "Mantenimiento de bombas y cisternas", LocalDate.of(2021, 11, 10), "DISPONIBLE"
        ));
    }

    public List<Tecnico> obtenerTodos() {
        return tecnicos.toList();
    }

    public Optional<Tecnico> obtenerPorId(Long id) {
        return tecnicos.toList().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public Tecnico crear(CreateTecnicoDTO dto) {
        Tecnico nuevo = new Tecnico(
                nextId++,
                dto.getNombre(),
                dto.getApellidos(),
                dto.getTelefono(),
                dto.getCorreo(),
                dto.getEspecialidad(),
                dto.getFechaContratacion() != null ? dto.getFechaContratacion() : LocalDate.now(),
                dto.getDisponibilidad() != null ? dto.getDisponibilidad() : "DISPONIBLE"
        );
        tecnicos.add(nuevo);
        return nuevo;
    }
}