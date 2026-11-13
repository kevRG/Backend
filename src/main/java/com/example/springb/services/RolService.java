package com.example.springb.services;

import com.example.springb.dto.CreateRolRequest;
import com.example.springb.models.Rol;
import com.example.springb.structures.CustomLinkedList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    private final CustomLinkedList<Rol> roles;
    private Long nextId = 1L;

    public RolService() {
        this.roles = new CustomLinkedList<>();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        guardar("Administrador", "Gestión total del sistema y alta de empleados");
        guardar("Operadora central", "Monitoreo y despacho desde el centro operativo");
        guardar("Técnico", "Atención de reportes y mantenimiento en campo");
        guardar("Ciudadano", "Consulta pública del estado de la red");
    }

    public List<Rol> obtenerTodos() {
        return roles.toList();
    }

    public Optional<Rol> obtenerPorId(Long id) {
        return roles.find(r -> r.getIdRol().equals(id));
    }

    /**
     * Valida los datos y crea el rol con estado "activo".
     * Lanza IllegalArgumentException si algún dato no es válido
     * e IllegalStateException si ya existe un rol con ese nombre.
     */
    public Rol crear(CreateRolRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("El cuerpo de la petición es obligatorio");
        }
        if (request.getNombreRol() == null || request.getNombreRol().isBlank()
                || request.getNombreRol().trim().length() > 50) {
            throw new IllegalArgumentException("nombreRol es obligatorio y tiene máximo 50 caracteres");
        }
        if (request.getDescripcion() != null && request.getDescripcion().length() > 255) {
            throw new IllegalArgumentException("descripcion tiene máximo 255 caracteres");
        }

        String nombre = request.getNombreRol().trim();
        if (roles.find(r -> r.getNombreRol().equalsIgnoreCase(nombre)).isPresent()) {
            throw new IllegalStateException("Ya existe el rol " + nombre);
        }
        String descripcion = request.getDescripcion() != null ? request.getDescripcion().trim() : null;
        return guardar(nombre, descripcion);
    }

    private Rol guardar(String nombre, String descripcion) {
        Rol rol = new Rol(nextId++, nombre, descripcion, "activo");
        roles.add(rol);
        return rol;
    }
}
