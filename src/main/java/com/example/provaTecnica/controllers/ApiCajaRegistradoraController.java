package com.example.provaTecnica.controllers;

import com.example.provaTecnica.dto.ResultatSaldoCajaDTO;
import com.example.provaTecnica.dto.search.CercaSaldoDTO;
import com.example.provaTecnica.services.CajaRegistradoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/api/v1/cajaRegistradora")
public class ApiCajaRegistradoraController {
        @Inject
    private CajaRegistradoraService cajaRegistradoraService;

    @PostMapping("/getSaldoCaja")
    public ResponseEntity<ResultatSaldoCajaDTO> getSaldoCaja(@RequestBody CercaSaldoDTO filter) {
        return ResponseEntity.ok(cajaRegistradoraService.getSaldoCaja(filter));
    }

    @PostMapping("/getSaldoCajaByDate")
    public ResponseEntity<ResultatSaldoCajaDTO> getSaldoCajaByDate(@RequestBody CercaSaldoDTO filter) {
        return ResponseEntity.ok(cajaRegistradoraService.getSaldoCajaByDate(filter));
    }


}
