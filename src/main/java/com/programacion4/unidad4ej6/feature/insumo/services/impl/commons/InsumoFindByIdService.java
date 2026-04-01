package com.programacion4.unidad4ej6.feature.insumo.services.impl.commons;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.commons.IInsumoFindByIdService;

import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.config.exceptions.NotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InsumoFindByIdService implements IInsumoFindByIdService {
    
    private final IInsumoRepository insumoRepository;

    @Override
    public Insumo findByIdAndActivoTrue(Long id) {
        Optional<Insumo> insumo = insumoRepository.findByIdAndActivoTrue(id);
        if (insumo.isEmpty()) {
            throw new NotFoundException("Insumo no encontrado");
        }
        return insumo.get();
    }
}
