package com.example.provaTecnica.dto.search;

import java.io.Serializable;
import java.time.LocalDate;

public class CercaSaldoDTO implements Serializable {


    private static final long serialVersionUID = -1368259271913760910L;
    private Long numeroCaja;
    private LocalDate fecha;

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
}
