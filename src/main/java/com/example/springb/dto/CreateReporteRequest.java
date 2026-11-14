package com.example.springb.dto;

/**
 * Datos que manda el cliente para levantar un reporte. No lleva id: la fecha, la hora
 * y el estado los pone el service.
 */
public class CreateReporteRequest {
    private Long idCiudadano;
    private Long idCategoria;
    private Long idVivienda;
    private Long idTuberia;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String fotografia;
    private String nivelPrioridad;

    public CreateReporteRequest() {}

    public CreateReporteRequest(Long idCiudadano, Long idCategoria, Long idVivienda, Long idTuberia,
                                String titulo, String descripcion, String ubicacion, String fotografia,
                                String nivelPrioridad) {
        this.idCiudadano = idCiudadano;
        this.idCategoria = idCategoria;
        this.idVivienda = idVivienda;
        this.idTuberia = idTuberia;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.fotografia = fotografia;
        this.nivelPrioridad = nivelPrioridad;
    }

    public Long getIdCiudadano() { return idCiudadano; }
    public void setIdCiudadano(Long idCiudadano) { this.idCiudadano = idCiudadano; }

    public Long getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Long idCategoria) { this.idCategoria = idCategoria; }

    public Long getIdVivienda() { return idVivienda; }
    public void setIdVivienda(Long idVivienda) { this.idVivienda = idVivienda; }

    public Long getIdTuberia() { return idTuberia; }
    public void setIdTuberia(Long idTuberia) { this.idTuberia = idTuberia; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getFotografia() { return fotografia; }
    public void setFotografia(String fotografia) { this.fotografia = fotografia; }

    public String getNivelPrioridad() { return nivelPrioridad; }
    public void setNivelPrioridad(String nivelPrioridad) { this.nivelPrioridad = nivelPrioridad; }
}
