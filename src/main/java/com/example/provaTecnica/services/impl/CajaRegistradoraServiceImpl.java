package com.example.provaTecnica.services.impl;

import com.example.provaTecnica.converter.CajaRegistradoraMapper;
import com.example.provaTecnica.dto.ResultatSaldoCajaDTO;
import com.example.provaTecnica.dto.search.CercaSaldoDTO;
import com.example.provaTecnica.model.CajaRegistradora;
import com.example.provaTecnica.services.CajaRegistradoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class CajaRegistradoraServiceImpl implements CajaRegistradoraService {
    private Set<CajaRegistradora> cajaRegistradoraSet;

    @Inject
    CajaRegistradoraMapper cajaRegistradoraMapper;

    @Override
    public ResultatSaldoCajaDTO getSaldoCaja(CercaSaldoDTO filter) {
        this.cajaRegistradoraSet = new HashSet<>();
        generateMock();
        return cajaRegistradoraSet.stream()
                .filter(cajaRegistradora -> cajaRegistradora.getNumeroCaja().equals(filter.getNumeroCaja()) && cajaRegistradora.getFecha().equals(filter.getFecha()))
                .map(cajaRegistradoraMapper::toResultatSaldoCajaDTO)
                .findAny().orElse(new ResultatSaldoCajaDTO());
    }

    @Override
    public ResultatSaldoCajaDTO getSaldoCajaByDate(CercaSaldoDTO filter) {
        this.cajaRegistradoraSet = new HashSet<>();
        generateMock();
        Double saldoTotal = 0.0;
        ResultatSaldoCajaDTO resultatSaldoCajaDTO = new ResultatSaldoCajaDTO();
        for (CajaRegistradora cajaRegistradora : cajaRegistradoraSet) {
            if (cajaRegistradora.getFecha().equals(filter.getFecha())) {
                saldoTotal += cajaRegistradora.getSaldo();
            }
        }
        resultatSaldoCajaDTO.setSaldo(saldoTotal);
        return resultatSaldoCajaDTO;
    }

    private void generateMock(){
        CajaRegistradora cajaRegistradora = new CajaRegistradora();
        cajaRegistradora.setNumeroCaja(1L);
        cajaRegistradora.setFecha(LocalDate.parse("05/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        cajaRegistradora.setSaldo(1000.0);
        cajaRegistradoraSet.add(cajaRegistradora);

        cajaRegistradora = new CajaRegistradora();
        cajaRegistradora.setNumeroCaja(2L);
        cajaRegistradora.setFecha(LocalDate.parse("15/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        cajaRegistradora.setSaldo(1250.0);
        cajaRegistradoraSet.add(cajaRegistradora);

        cajaRegistradora = new CajaRegistradora();
        cajaRegistradora.setNumeroCaja(3L);
        cajaRegistradora.setFecha(LocalDate.parse("10/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        cajaRegistradora.setSaldo(1130.0);
        cajaRegistradoraSet.add(cajaRegistradora);

        cajaRegistradora = new CajaRegistradora();
        cajaRegistradora.setNumeroCaja(4L);
        cajaRegistradora.setFecha(LocalDate.parse("20/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        cajaRegistradora.setSaldo(980.0);
        cajaRegistradora.setDescripcion("Desc4");
        cajaRegistradoraSet.add(cajaRegistradora);

        cajaRegistradora = new CajaRegistradora();
        cajaRegistradora.setNumeroCaja(5L);
        cajaRegistradora.setFecha(LocalDate.parse("25/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        cajaRegistradora.setSaldo(825.0);
        cajaRegistradora.setDescripcion("Desc5");
        cajaRegistradoraSet.add(cajaRegistradora);

        cajaRegistradora = new CajaRegistradora();
        cajaRegistradora.setNumeroCaja(6L);
        cajaRegistradora.setFecha(LocalDate.parse("25/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        cajaRegistradora.setSaldo(900.58);
        cajaRegistradora.setDescripcion("Desc5");
        cajaRegistradoraSet.add(cajaRegistradora);

    }


}
