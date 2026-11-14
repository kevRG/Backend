package com.example.springb.services;

import com.example.springb.dto.CreateReporteRequest;
import com.example.springb.models.Reporte;
import com.example.springb.structures.Cola;
import com.example.springb.structures.CustomLinkedList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ReporteService {

    public static final String SIN_ASIGNAR = "Sin asignar";
    public static final String EN_PROCESO = "En proceso";
    private static final List<String> PRIORIDADES = List.of("Crítica", "Alta", "Media", "Baja");

    /** Todos los reportes (lista ligada propia). */
    private final CustomLinkedList<Reporte> reportes;
    /** Reportes sin asignar en orden de llegada: el primero en llegar es el primero en atenderse. */
    private final Cola<Reporte> pendientes;
    private Long nextId = 201L;

    public ReporteService() {
        this.reportes = new CustomLinkedList<>();
        this.pendientes = new Cola<>();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        LocalDate hoy = LocalDate.now();
        guardar(4L, 4L, 4L, null, "Falta de agua", "No llegó el agua en el horario de tandeo.",
                hoy.minusDays(1), LocalTime.of(15, 31), "Circuito Sur 114", null, "Media", "Programado");
        guardar(3L, 3L, 3L, 3L, "Baja presión", "La presión bajó desde la mañana.",
                hoy.minusDays(1), LocalTime.of(18, 5), "Priv. Norte 8", null, "Media", "Diagnóstico");
        guardar(2L, 2L, 2L, 2L, "Fuga en calle", "Fuga que corre por toda la calle.",
                hoy, LocalTime.of(8, 16), "Calle Fresno 22", null, "Alta", EN_PROCESO);
        guardar(1L, 1L, 1L, 1L, "Fuga abundante sobre vía principal",
                "El agua está saliendo desde una grieta visible en el pavimento y ya cubre ambos carriles.",
                hoy, LocalTime.of(9, 42), "Av. Reforma 184", "reportes/rep-204.jpg", "Crítica", SIN_ASIGNAR);
        guardar(4L, 5L, 4L, null, "Agua turbia", "El agua salió turbia en la mañana.",
                hoy, LocalTime.of(10, 5), "Calle Hidalgo 45", null, "Baja", SIN_ASIGNAR);
    }

    public List<Reporte> obtenerTodos() {
        return reportes.toList();
    }

    public Optional<Reporte> obtenerPorId(Long id) {
        return reportes.find(r -> r.getIdReporte().equals(id));
    }

    /** Cola de reportes sin asignar, del primero al último en llegar. */
    public List<Reporte> obtenerPendientes() {
        return pendientes.toList();
    }

    /**
     * Valida los datos y levanta el reporte con estado "Sin asignar"; también entra a la cola.
     * Lanza IllegalArgumentException si algún dato no es válido.
     */
    public Reporte crear(CreateReporteRequest request) {
        validar(request);
        LocalTime hora = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        String fotografia = request.getFotografia() != null ? request.getFotografia().trim() : null;
        return guardar(request.getIdCiudadano(), request.getIdCategoria(), request.getIdVivienda(),
                request.getIdTuberia(), request.getTitulo().trim(), request.getDescripcion().trim(),
                LocalDate.now(), hora, request.getUbicacion().trim(), fotografia,
                request.getNivelPrioridad().trim(), SIN_ASIGNAR);
    }

    /**
     * Saca de la cola el reporte que lleva más tiempo esperando y lo marca "En proceso".
     * Regresa Optional vacío si no hay reportes pendientes.
     */
    public Optional<Reporte> atenderSiguiente() {
        Reporte reporte = pendientes.desencolar();
        if (reporte == null) {
            return Optional.empty();
        }
        reporte.setEstado(EN_PROCESO);
        return Optional.of(reporte);
    }

    private void validar(CreateReporteRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("El cuerpo de la petición es obligatorio");
        }
        if (request.getIdCiudadano() == null) {
            throw new IllegalArgumentException("idCiudadano es obligatorio");
        }
        if (request.getIdCategoria() == null) {
            throw new IllegalArgumentException("idCategoria es obligatorio");
        }
        if (estaVacio(request.getTitulo()) || request.getTitulo().trim().length() > 150) {
            throw new IllegalArgumentException("titulo es obligatorio y tiene máximo 150 caracteres");
        }
        if (estaVacio(request.getDescripcion())) {
            throw new IllegalArgumentException("descripcion es obligatoria");
        }
        if (estaVacio(request.getUbicacion()) || request.getUbicacion().trim().length() > 255) {
            throw new IllegalArgumentException("ubicacion es obligatoria y tiene máximo 255 caracteres");
        }
        if (request.getFotografia() != null && request.getFotografia().length() > 255) {
            throw new IllegalArgumentException("fotografia tiene máximo 255 caracteres");
        }
        if (request.getNivelPrioridad() == null || !PRIORIDADES.contains(request.getNivelPrioridad().trim())) {
            throw new IllegalArgumentException("nivelPrioridad debe ser Crítica, Alta, Media o Baja");
        }
    }

    private boolean estaVacio(String texto) {
        return texto == null || texto.isBlank();
    }

    private Reporte guardar(Long idCiudadano, Long idCategoria, Long idVivienda, Long idTuberia, String titulo,
                            String descripcion, LocalDate fecha, LocalTime hora, String ubicacion,
                            String fotografia, String prioridad, String estado) {
        Reporte reporte = new Reporte(nextId++, idCiudadano, idCategoria, idVivienda, idTuberia, titulo,
                descripcion, fecha, hora, ubicacion, fotografia, prioridad, estado);
        reportes.add(reporte);
        if (SIN_ASIGNAR.equals(estado)) {
            pendientes.encolar(reporte);
        }
        return reporte;
    }
}
