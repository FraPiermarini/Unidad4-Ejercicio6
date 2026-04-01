package com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain;

import com.programacion4.unidad4ej6.feature.insumo.dtos.request.InsumoCreateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;

public interface IInsumoCreateService {
    
    InsumoResponseDTO createInsumo(InsumoCreateDTO dto);

}
