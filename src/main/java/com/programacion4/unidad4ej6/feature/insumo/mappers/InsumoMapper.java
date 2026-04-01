package com.programacion4.unidad4ej6.feature.insumo.mappers;

import java.math.BigDecimal;

import com.programacion4.unidad4ej6.feature.insumo.models.HistorialPrecio;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.models.MovimientoStock;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;

import java.util.stream.Collectors;
import java.util.ArrayList;

import com.programacion4.unidad4ej6.feature.insumo.dtos.request.InsumoCreateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.HistorialPrecioResponseDTO;

public class InsumoMapper {
    
    public static InsumoResponseDTO toResponseDTO(Insumo insumo) {
        return InsumoResponseDTO.builder()
                .id(insumo.getId())
                .nombre(insumo.getNombre())
                .codigoInterno(insumo.getCodigoInterno())
                .stockActual(insumo.getStockActual())
                .activo(insumo.getActivo())
                .precioActual(
                    insumo.getHistorialPrecios().isEmpty() 
                    ? BigDecimal.ZERO
                    : insumo.getHistorialPrecios().get(insumo.getHistorialPrecios().size() - 1).getPrecio()
                )
                .historialPrecios(
                    insumo.getHistorialPrecios().isEmpty() 
                    ? new ArrayList<HistorialPrecioResponseDTO>()
                    : insumo.getHistorialPrecios().stream().map(HistorialPrecioMapper::toResponseDTO).collect(Collectors.toList())
                )
                .build();
    }

    public static Insumo toEntity(InsumoCreateDTO insumoCreateDTO) {
        return Insumo.builder()
                .nombre(insumoCreateDTO.getNombre())
                .codigoInterno(insumoCreateDTO.getCodigoInterno())
                .stockActual(0L)
                .activo(true)
                .historialPrecios(new ArrayList<HistorialPrecio>())
                .movimientosStock(new ArrayList<MovimientoStock>())
                .build();
    }
}
