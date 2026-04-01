package com.programacion4.unidad4ej6.feature.insumo.dtos.response;

import java.time.LocalDateTime;

import com.programacion4.unidad4ej6.feature.insumo.models.TipoMovimiento;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@Builder    
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoStockResponseDTO {

    private Long id;

    private Long cantidad;

    private TipoMovimiento tipo;

    private LocalDateTime fecha;

}
