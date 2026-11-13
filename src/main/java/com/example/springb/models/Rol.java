package com.example.springb.models;

/**
 * Tabla Roles. Los campos coinciden con las columnas de la base de datos.
 */
public class Rol {
    private Long idRol;
    private String nombreRol;
    private String descripcion;
    private String estado;

    public Rol() {
    }

    public Rol(
            Long idRol,
            String nombreRol,
            String descripcion,
            String estado
    ) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
