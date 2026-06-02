package com.programacion4.unidad4ej6.feature.insumo.services.interfaces.commons;

import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;

public interface IInsumoFindDeletedByIdService {
    
    Insumo findByIdAndActivoFalse(Long id);
}
