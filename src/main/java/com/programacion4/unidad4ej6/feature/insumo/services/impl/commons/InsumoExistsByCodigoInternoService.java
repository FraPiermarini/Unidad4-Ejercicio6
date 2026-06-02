package com.programacion4.unidad4ej6.feature.insumo.services.impl.commons;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.commons.IInsumoExistsByCodigoInternoService;

import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;

@Service
@AllArgsConstructor
public class InsumoExistsByCodigoInternoService implements IInsumoExistsByCodigoInternoService {

    private final IInsumoRepository insumoRepository;

    @Override
    public boolean existsByCodigoInterno(String codigoInterno) {
        return insumoRepository.existsByCodigoInterno(codigoInterno);
    }
}
