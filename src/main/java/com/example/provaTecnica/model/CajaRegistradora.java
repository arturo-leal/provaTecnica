package com.example.provaTecnica.model;

import java.time.LocalDate;

public class CajaRegistradora {
    private Long numeroCaja;
    private LocalDate fecha;
    private Double saldo;
    private String descripcion;

    public Long getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(Long numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
