package com.example.springb.models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Tabla Reportes. Los campos coinciden con las columnas de la base de datos.
 */
public class Reporte {
    private Long idReporte;
    private Long idCiudadano;
    private Long idCategoria;
    private Long idVivienda;
    private Long idTuberia;
    private String titulo;
    private String descripcion;
    private LocalDate fechaReporte;
    private LocalTime horaReporte;
    private String ubicacion;
    private String fotografia;
    private String nivelPrioridad;
    private String estado;

    public Reporte() {
    }

    public Reporte(
            Long idReporte,
            Long idCiudadano,
            Long idCategoria,
            Long idVivienda,
            Long idTuberia,
            String titulo,
            String descripcion,
            LocalDate fechaReporte,
            LocalTime horaReporte,
            String ubicacion,
            String fotografia,
            String nivelPrioridad,
            String estado
    ) {
        this.idReporte = idReporte;
        this.idCiudadano = idCiudadano;
        this.idCategoria = idCategoria;
        this.idVivienda = idVivienda;
        this.idTuberia = idTuberia;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaReporte = fechaReporte;
        this.horaReporte = horaReporte;
        this.ubicacion = ubicacion;
        this.fotografia = fotografia;
        this.nivelPrioridad = nivelPrioridad;
        this.estado = estado;
    }

    public Long getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Long idReporte) {
        this.idReporte = idReporte;
    }

    public Long getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(Long idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(Long idVivienda) {
        this.idVivienda = idVivienda;
    }

    public Long getIdTuberia() {
        return idTuberia;
    }

    public void setIdTuberia(Long idTuberia) {
        this.idTuberia = idTuberia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public LocalTime getHoraReporte() {
        return horaReporte;
    }

    public void setHoraReporte(LocalTime horaReporte) {
        this.horaReporte = horaReporte;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(String nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
