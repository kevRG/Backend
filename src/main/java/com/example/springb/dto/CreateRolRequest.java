package com.example.springb.dto;

/** Datos que manda el cliente para crear un rol. No lleva id ni estado: los asigna el service. */
public class CreateRolRequest {
    private String nombreRol;
    private String descripcion;

    public CreateRolRequest() {}

    public CreateRolRequest(String nombreRol, String descripcion) {
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
    }

    public String getNombreRol() { return nombreRol; }
    public void setNombreRol(String nombreRol) { this.nombreRol = nombreRol; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
