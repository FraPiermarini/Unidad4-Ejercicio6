package com.programacion4.unidad4ej6.feature.insumo.services.impl.commons;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.commons.IInsumoFindDeletedByIdService;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;

import java.util.Optional;

import com.programacion4.unidad4ej6.config.exceptions.NotFoundException;

@Service
@AllArgsConstructor
public class InsumoFindDeletedByIdService implements IInsumoFindDeletedByIdService {
    
    private final IInsumoRepository insumoRepository;

    @Override
    public Insumo findByIdAndActivoFalse(Long id) {
        Optional<Insumo> insumo = insumoRepository.findByIdAndActivoFalse(id);
        if (insumo.isEmpty()) {
            throw new NotFoundException("Insumo no encontrado");
        }
        return insumo.get();
    }
}
