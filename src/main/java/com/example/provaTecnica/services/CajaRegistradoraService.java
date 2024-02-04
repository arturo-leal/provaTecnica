package com.example.provaTecnica.services;

import com.example.provaTecnica.dto.ResultatSaldoCajaDTO;
import com.example.provaTecnica.dto.search.CercaSaldoDTO;

public interface CajaRegistradoraService {
    ResultatSaldoCajaDTO getSaldoCaja(CercaSaldoDTO filter);

    ResultatSaldoCajaDTO getSaldoCajaByDate(CercaSaldoDTO filter);
}
