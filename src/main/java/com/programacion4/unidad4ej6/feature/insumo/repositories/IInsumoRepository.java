package com.programacion4.unidad4ej6.feature.insumo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;

import java.util.Optional;

@Repository
public interface IInsumoRepository extends CrudRepository<Insumo, Long> {

    boolean existsByCodigoInterno(String codigoInterno);

    Optional<Insumo> findByIdAndActivoTrue(Long id);

    Optional<Insumo> findByIdAndActivoFalse(Long id);
    
}
