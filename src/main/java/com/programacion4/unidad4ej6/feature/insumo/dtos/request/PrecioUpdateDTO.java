package com.programacion4.unidad4ej6.feature.insumo.dtos.request;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrecioUpdateDTO {

    @Positive(message = "El nuevo precio debe ser mayor a 0")
    @NotNull(message = "El nuevo precio es requerido")
    private BigDecimal nuevoPrecio;

}
