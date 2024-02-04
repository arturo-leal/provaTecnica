package com.example.provaTecnica.converter;

import com.example.provaTecnica.dto.ResultatSaldoCajaDTO;
import com.example.provaTecnica.model.CajaRegistradora;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CajaRegistradoraMapper {
    ResultatSaldoCajaDTO toResultatSaldoCajaDTO(CajaRegistradora cajaRegistradora);
}
