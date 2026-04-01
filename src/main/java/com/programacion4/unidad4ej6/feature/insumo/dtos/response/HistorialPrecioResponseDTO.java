package com.programacion4.unidad4ej6.feature.insumo.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialPrecioResponseDTO {
    
    private Long id;

    private BigDecimal precio;

    private LocalDateTime fechaEntradaVigencia;
    
}
