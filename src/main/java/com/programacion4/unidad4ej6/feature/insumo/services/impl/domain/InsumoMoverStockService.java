package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoMoverStockService;
import com.programacion4.unidad4ej6.config.exceptions.BadRequestException;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.MovimientoStockDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.MovimientoStockResponseDTO;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.commons.IInsumoFindByIdService;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.mappers.MovimientoStockMapper;
import com.programacion4.unidad4ej6.feature.insumo.models.TipoMovimiento;

@Service
@AllArgsConstructor
public class InsumoMoverStockService implements IInsumoMoverStockService {
    
    private final IInsumoFindByIdService insumoFindByIdService;

    private final IInsumoRepository insumoRepository;

    @Override
    public MovimientoStockResponseDTO moverStock(Long id, MovimientoStockDTO dto) {

        Insumo insumo = insumoFindByIdService.findByIdAndActivoTrue(id);

        // Si el tipo de movimiento es entrada, se suma el stock actual
        if (dto.getTipoMovimiento().name().equals(TipoMovimiento.ENTRADA.name())) {

            insumo.setStockActual(insumo.getStockActual() + dto.getCantidad());

        // Si el tipo de movimiento es salida, se resta el stock actual
        // siempre y cuando el stock actual sea mayor o igual a la cantidad a restar
        } else if (insumo.getStockActual() >= dto.getCantidad()) {

            insumo.setStockActual(insumo.getStockActual() - dto.getCantidad());

        // Si el stock actual es menor a la cantidad a restar, se lanza una excepción
        } else {
            throw new BadRequestException("No hay suficiente stock para realizar la salida");
        }

        insumo.getMovimientosStock().add(MovimientoStockMapper.toEntity(dto, insumo));

        insumoRepository.save(insumo);

        return MovimientoStockMapper.toResponseDTO(
            insumo.getMovimientosStock().get(insumo.getMovimientosStock().size() - 1)
        );
    }
}
