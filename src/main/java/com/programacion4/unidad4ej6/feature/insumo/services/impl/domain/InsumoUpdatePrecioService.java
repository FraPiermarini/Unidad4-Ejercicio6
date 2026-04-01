package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoUpdatePrecioService;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.PrecioUpdateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.commons.IInsumoFindByIdService;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.mappers.HistorialPrecioMapper;
import com.programacion4.unidad4ej6.feature.insumo.mappers.InsumoMapper;
import com.programacion4.unidad4ej6.feature.insumo.models.HistorialPrecio;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;

@Service
@AllArgsConstructor
public class InsumoUpdatePrecioService implements IInsumoUpdatePrecioService {
    
    private final IInsumoFindByIdService insumoFindByIdService;

    private final IInsumoRepository insumoRepository;

    @Override
    public InsumoResponseDTO updatePrecio(Long id, PrecioUpdateDTO dto) {

        Insumo insumo = insumoFindByIdService.findByIdAndActivoTrue(id);

        HistorialPrecio historialPrecio = HistorialPrecioMapper.toEntity(dto.getNuevoPrecio(), insumo);

        insumo.getHistorialPrecios().add(historialPrecio);

        insumoRepository.save(insumo);
        
        return InsumoMapper.toResponseDTO(insumo);
    }

}
