package com.programacion4.unidad4ej6.feature.insumo.mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.programacion4.unidad4ej6.feature.insumo.models.HistorialPrecio;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;

import com.programacion4.unidad4ej6.feature.insumo.dtos.response.HistorialPrecioResponseDTO;

public class HistorialPrecioMapper {
    
    public static HistorialPrecioResponseDTO toResponseDTO(HistorialPrecio historialPrecio) {
        return HistorialPrecioResponseDTO.builder()
                .id(historialPrecio.getId())
                .precio(historialPrecio.getPrecio())
                .fechaEntradaVigencia(historialPrecio.getFechaEntradaVigencia())
                .build();
    }

    public static HistorialPrecio toEntity(BigDecimal precio, Insumo insumo) {
        return HistorialPrecio.builder()
                .precio(precio)
                .fechaEntradaVigencia(LocalDateTime.now())
                .insumo(insumo)
                .build();
    }

}
