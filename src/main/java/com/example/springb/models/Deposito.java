package com.example.springb.models;

import java.time.LocalDate;

public class Deposito {
    private Long id;
    private String nombreDeposito;
    private Double capacidadLitros;
    private Double nivelActualLitros;
    private String tipoDeposito;
    private String ubicacion;
    private LocalDate fechaInstalacion;
    private String estado;

    public Deposito() {}

    public Deposito(Long id, String nombreDeposito, Double capacidadLitros, Double nivelActualLitros,
                    String tipoDeposito, String ubicacion, LocalDate fechaInstalacion, String estado) {
        this.id = id;
        this.nombreDeposito = nombreDeposito;
        this.capacidadLitros = capacidadLitros;
        this.nivelActualLitros = nivelActualLitros;
        this.tipoDeposito = tipoDeposito;
        this.ubicacion = ubicacion;
        this.fechaInstalacion = fechaInstalacion;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreDeposito() { return nombreDeposito; }
    public void setNombreDeposito(String nombreDeposito) { this.nombreDeposito = nombreDeposito; }

    public Double getCapacidadLitros() { return capacidadLitros; }
    public void setCapacidadLitros(Double capacidadLitros) { this.capacidadLitros = capacidadLitros; }

    public Double getNivelActualLitros() { return nivelActualLitros; }
    public void setNivelActualLitros(Double nivelActualLitros) { this.nivelActualLitros = nivelActualLitros; }

    public String getTipoDeposito() { return tipoDeposito; }
    public void setTipoDeposito(String tipoDeposito) { this.tipoDeposito = tipoDeposito; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public LocalDate getFechaInstalacion() { return fechaInstalacion; }
    public void setFechaInstalacion(LocalDate fechaInstalacion) { this.fechaInstalacion = fechaInstalacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}