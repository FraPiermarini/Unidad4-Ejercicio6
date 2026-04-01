package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoGetService;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.mappers.InsumoMapper;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.commons.IInsumoFindByIdService;

@Service
@AllArgsConstructor
public class InsumoGetService implements IInsumoGetService {
    
    private final IInsumoFindByIdService insumoFindByIdService;

    @Override
    public InsumoResponseDTO getInsumo(Long id) {
        return InsumoMapper.toResponseDTO(insumoFindByIdService.findByIdAndActivoTrue(id));
    }
}
