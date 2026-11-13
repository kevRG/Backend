package com.example.springb.services;

import com.example.springb.dto.CreateColoniaRequest;
import com.example.springb.models.Colonia;
import com.example.springb.structures.CustomLinkedList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColoniaService {
    private final CustomLinkedList<Colonia> colonias;
    private Long nextId = 1L;

    public ColoniaService() {
        this.colonias = new CustomLinkedList<>();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        guardar("Centro", "Cuernavaca", "62000", "Zona centro y comercial", 18.946, -99.254);
        guardar("San Baltazar", "Cuernavaca", "62030", "Zona habitacional oriente", 18.949, -99.2283);
        guardar("Los Fuertes", "Cuernavaca", "62040", "Zona habitacional norte", 18.9545, -99.2622);
        guardar("La Paz", "Cuernavaca", "62050", "Zona habitacional poniente", 18.94, -99.275);
        guardar("Lomas del Valle", "Cuernavaca", "62060", "Zona habitacional sur", 18.9507, -99.2253);
    }

    public List<Colonia> obtenerTodas() {
        return colonias.toList();
    }

    public Optional<Colonia> obtenerPorId(Long id) {
        return colonias.find(c -> c.getIdColonia().equals(id));
    }

    public boolean existe(Long id) {
        return obtenerPorId(id).isPresent();
    }

    /**
     * Valida los datos y registra la colonia.
     * Lanza IllegalArgumentException si algún dato no es válido
     * e IllegalStateException si ya existe una colonia con ese nombre.
     */
    public Colonia crear(CreateColoniaRequest request) {
        validar(request);

        String nombre = request.getNombreColonia().trim();
        if (colonias.find(c -> c.getNombreColonia().equalsIgnoreCase(nombre)).isPresent()) {
            throw new IllegalStateException("Ya existe la colonia " + nombre);
        }

        String descripcion = request.getDescripcion() != null ? request.getDescripcion().trim() : null;
        return guardar(nombre, request.getMunicipio().trim(), request.getCodigoPostal().trim(), descripcion,
                request.getLatitud(), request.getLongitud());
    }

    private void validar(CreateColoniaRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("El cuerpo de la petición es obligatorio");
        }
        if (estaVacio(request.getNombreColonia()) || request.getNombreColonia().trim().length() > 100) {
            throw new IllegalArgumentException("nombreColonia es obligatorio y tiene máximo 100 caracteres");
        }
        if (estaVacio(request.getMunicipio()) || request.getMunicipio().trim().length() > 100) {
            throw new IllegalArgumentException("municipio es obligatorio y tiene máximo 100 caracteres");
        }
        if (request.getCodigoPostal() == null || !request.getCodigoPostal().trim().matches("\\d{5}")) {
            throw new IllegalArgumentException("codigoPostal debe tener 5 dígitos");
        }
        if (request.getDescripcion() != null && request.getDescripcion().length() > 255) {
            throw new IllegalArgumentException("descripcion tiene máximo 255 caracteres");
        }
        if (request.getLatitud() == null || request.getLatitud() < -90 || request.getLatitud() > 90) {
            throw new IllegalArgumentException("latitud es obligatoria y debe estar entre -90 y 90");
        }
        if (request.getLongitud() == null || request.getLongitud() < -180 || request.getLongitud() > 180) {
            throw new IllegalArgumentException("longitud es obligatoria y debe estar entre -180 y 180");
        }
    }

    private boolean estaVacio(String texto) {
        return texto == null || texto.isBlank();
    }

    private Colonia guardar(String nombre, String municipio, String codigoPostal, String descripcion,
                            Double latitud, Double longitud) {
        Colonia colonia = new Colonia(nextId++, nombre, municipio, codigoPostal, descripcion, latitud, longitud, "activa");
        colonias.add(colonia);
        return colonia;
    }
}
