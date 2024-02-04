package com.example.provaTecnica;

import com.example.provaTecnica.controllers.ApiCajaRegistradoraController;
import com.example.provaTecnica.dto.ResultatSaldoCajaDTO;
import com.example.provaTecnica.dto.search.CercaSaldoDTO;
import com.example.provaTecnica.services.CajaRegistradoraService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ApiCajaRegistradoraControllerTests {

    @Mock
    private CajaRegistradoraService cajaRegistradoraService;

    @InjectMocks
    private ApiCajaRegistradoraController controller;

    public ApiCajaRegistradoraControllerTests() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSaldoCaja() {
        CercaSaldoDTO mockFilter = new CercaSaldoDTO();
        ResultatSaldoCajaDTO mockResult = new ResultatSaldoCajaDTO();

        when(cajaRegistradoraService.getSaldoCaja(any(CercaSaldoDTO.class))).thenReturn(mockResult);

        ResponseEntity<ResultatSaldoCajaDTO> response = controller.getSaldoCaja(mockFilter);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResult, response.getBody());

        verify(cajaRegistradoraService, times(1)).getSaldoCaja(mockFilter);
    }

    @Test
    public void testGetSaldoCajaByDate() {
        CercaSaldoDTO mockFilter = new CercaSaldoDTO();
        ResultatSaldoCajaDTO mockResult = new ResultatSaldoCajaDTO();
        when(cajaRegistradoraService.getSaldoCajaByDate(any(CercaSaldoDTO.class))).thenReturn(mockResult);

        ResponseEntity<ResultatSaldoCajaDTO> response = controller.getSaldoCajaByDate(mockFilter);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResult, response.getBody());

        verify(cajaRegistradoraService, times(1)).getSaldoCajaByDate(mockFilter);
    }
}
