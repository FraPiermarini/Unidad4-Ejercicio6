package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoRecoveryService;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.commons.IInsumoFindDeletedByIdService;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;

@Service
@AllArgsConstructor
public class InsumoRecoveryService implements IInsumoRecoveryService {
    
    private final IInsumoFindDeletedByIdService insumoFindDeletedByIdService;

    private final IInsumoRepository insumoRepository;

    @Override
    public void recoveryInsumo(Long id) {
        Insumo insumo = insumoFindDeletedByIdService.findByIdAndActivoFalse(id);

        insumo.changeStatus();
        
        insumoRepository.save(insumo);
    }
}
