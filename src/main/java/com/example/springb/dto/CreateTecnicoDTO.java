package com.example.springb.dto;

import java.time.LocalDate;

public class CreateTecnicoDTO {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    private String especialidad;
    private LocalDate fechaContratacion;
    private String disponibilidad;

    public CreateTecnicoDTO() {}

    public CreateTecnicoDTO(String nombre, String apellidos, String telefono, String correo,
                            String especialidad, LocalDate fechaContratacion, String disponibilidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.especialidad = especialidad;
        this.fechaContratacion = fechaContratacion;
        this.disponibilidad = disponibilidad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public String getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(String disponibilidad) { this.disponibilidad = disponibilidad; }
}