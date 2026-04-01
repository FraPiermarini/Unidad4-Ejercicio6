package com.programacion4.unidad4ej6.feature.insumo.mappers;

import com.programacion4.unidad4ej6.feature.insumo.models.MovimientoStock;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.MovimientoStockResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import java.time.LocalDateTime;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.MovimientoStockDTO;

public class MovimientoStockMapper {
    
    public static MovimientoStockResponseDTO toResponseDTO(MovimientoStock movimientoStock) {
        return MovimientoStockResponseDTO.builder()
                .id(movimientoStock.getId())
                .cantidad(movimientoStock.getCantidad())
                .tipo(movimientoStock.getTipo())
                .fecha(movimientoStock.getFecha())
                .build();
    }

    public static MovimientoStock toEntity(MovimientoStockDTO dto, Insumo insumo) {
        return MovimientoStock.builder()
                .cantidad(dto.getCantidad())
                .tipo(dto.getTipoMovimiento())
                .fecha(LocalDateTime.now())
                .insumo(insumo)
                .build();
    }
}
