package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoCreateService;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.InsumoCreateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.mappers.InsumoMapper;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.mappers.HistorialPrecioMapper;
import com.programacion4.unidad4ej6.feature.insumo.models.HistorialPrecio;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.commons.IInsumoExistsByCodigoInternoService;
import com.programacion4.unidad4ej6.config.exceptions.ConflictException;

@Service
@AllArgsConstructor
public class InsumoCreateService implements IInsumoCreateService {
    
    private final IInsumoRepository insumoRepository;
    private final IInsumoExistsByCodigoInternoService insumoExistsByCodigoInternoService;
    @Override
    public InsumoResponseDTO createInsumo(InsumoCreateDTO dto) {

        if (insumoExistsByCodigoInternoService.existsByCodigoInterno(dto.getCodigoInterno())) {
            throw new ConflictException("El código interno ya esta registrado");
        }

        Insumo insumo = InsumoMapper.toEntity(dto);

        HistorialPrecio historialPrecio = HistorialPrecioMapper.toEntity(dto.getPrecio(), insumo);

        insumo.getHistorialPrecios().add(historialPrecio);

        // Gracias a CascadeType.ALL, JPA detecta que hay un 'primerPrecio' nuevo y lo guarda.
        Insumo insumoGuardado = insumoRepository.save(insumo);

        return InsumoMapper.toResponseDTO(insumoGuardado);
    }
}
