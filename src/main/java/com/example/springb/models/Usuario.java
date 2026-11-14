package com.example.springb.models;

public class Usuario {
    private Long idUsuario;
    private String nombreCompleto;
    private String nombreUsuario;
    private String correo;
    private String contrasenaHash;
    private String telefono;
    private String rol;
    private String ultimoAcceso;
    private String estado;

    public Usuario() {}

    public Usuario(Long idUsuario, String nombreCompleto, String nombreUsuario, String correo,
                   String contrasenaHash, String telefono, String rol, String ultimoAcceso, String estado) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasenaHash = contrasenaHash;
        this.telefono = telefono;
        this.rol = rol;
        this.ultimoAcceso = ultimoAcceso;
        this.estado = estado;
    }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasenaHash() { return contrasenaHash; }
    public void setContrasenaHash(String contrasenaHash) { this.contrasenaHash = contrasenaHash; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getUltimoAcceso() { return ultimoAcceso; }
    public void setUltimoAcceso(String ultimoAcceso) { this.ultimoAcceso = ultimoAcceso; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}