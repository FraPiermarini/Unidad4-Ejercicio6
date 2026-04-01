package com.programacion4.unidad4ej6.feature.insumo.dtos.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsumoResponseDTO {
    
    private Long id;

    private String nombre;

    private String codigoInterno;

    private Long stockActual;

    private Boolean activo;

    private BigDecimal precioActual;

    private List<HistorialPrecioResponseDTO> historialPrecios;
}
