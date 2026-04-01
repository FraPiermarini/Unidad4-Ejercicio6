package com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain;

import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;

public interface IInsumoGetService {
    
    InsumoResponseDTO getInsumo(Long id);
}
