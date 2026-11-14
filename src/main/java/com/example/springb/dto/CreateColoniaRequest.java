package com.example.springb.dto;

/**
 * Datos que manda el cliente para registrar una colonia. No lleva id ni estado:
 * los asigna el service.
 */
public class CreateColoniaRequest {
    private String nombreColonia;
    private String municipio;
    private String codigoPostal;
    private String descripcion;
    private Double latitud;
    private Double longitud;

    public CreateColoniaRequest() {}

    public CreateColoniaRequest(String nombreColonia, String municipio, String codigoPostal,
                                String descripcion, Double latitud, Double longitud) {
        this.nombreColonia = nombreColonia;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombreColonia() { return nombreColonia; }
    public void setNombreColonia(String nombreColonia) { this.nombreColonia = nombreColonia; }

    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
}
