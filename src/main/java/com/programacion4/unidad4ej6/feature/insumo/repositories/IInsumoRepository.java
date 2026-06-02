package com.programacion4.unidad4ej6.feature.insumo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;

import java.util.Optional;

@Repository
public interface IInsumoRepository extends JpaRepository<Insumo, Long> {

    boolean existsByCodigoInterno(String codigoInterno);

    Optional<Insumo> findByIdAndActivoTrue(Long id);

    Optional<Insumo> findByIdAndActivoFalse(Long id);
    
}
