package com.programacion4.unidad4ej6.feature.insumo.dtos.response;

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

    private Double precioEnDolares;

    private Double valorDolarReferencia;

    private Double precioEnPesos;
}
