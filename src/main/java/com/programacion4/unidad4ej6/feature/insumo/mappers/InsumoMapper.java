package com.programacion4.unidad4ej6.feature.insumo.mappers;

import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.InsumoCreateDTO;

public class InsumoMapper {
    
    public static InsumoResponseDTO toResponseDTO(Insumo insumo) {
        return InsumoResponseDTO.builder()
                .id(insumo.getId())
                .nombre(insumo.getNombre())
                .codigoInterno(insumo.getCodigoInterno())
                .stockActual(insumo.getStockActual())
                .activo(insumo.getActivo())
                .precioEnDolares(insumo.getPrecioEnDolares())
                .valorDolarReferencia(insumo.getValorDolarReferencia())
                .precioEnPesos(insumo.getPrecioEnPesos())
                .build();
    }

    public static Insumo toEntity(InsumoCreateDTO insumoCreateDTO) {
        Double precioEnPesos = calcularPrecioEnPesos(
                insumoCreateDTO.getPrecioEnDolares(),
                insumoCreateDTO.getValorDolarReferencia()
        );

        return Insumo.builder()
                .nombre(insumoCreateDTO.getNombre())
                .codigoInterno(insumoCreateDTO.getCodigoInterno())
                .stockActual(0L)
                .activo(true)
                .precioEnDolares(insumoCreateDTO.getPrecioEnDolares())
                .valorDolarReferencia(insumoCreateDTO.getValorDolarReferencia())
                .precioEnPesos(precioEnPesos)
                .build();
    }

    private static Double calcularPrecioEnPesos(Double precioEnDolares, Double valorDolarReferencia) {
        return precioEnDolares * valorDolarReferencia;
    }
}
