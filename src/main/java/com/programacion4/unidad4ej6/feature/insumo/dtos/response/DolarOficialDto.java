package com.programacion4.unidad4ej6.feature.insumo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DolarOficialDto {

    private Double compra;
    private Double venta;
    private String casa;
    private String nombre;
    private String moneda;
    private String fechaActualizacion;

}