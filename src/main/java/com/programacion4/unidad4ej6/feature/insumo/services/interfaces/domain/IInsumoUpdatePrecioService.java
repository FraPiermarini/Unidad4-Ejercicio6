package com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain;

import com.programacion4.unidad4ej6.feature.insumo.dtos.request.PrecioUpdateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;

public interface IInsumoUpdatePrecioService {
    
    InsumoResponseDTO updatePrecio(Long id, PrecioUpdateDTO dto);

}
