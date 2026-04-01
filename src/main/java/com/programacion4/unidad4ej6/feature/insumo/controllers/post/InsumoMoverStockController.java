package com.programacion4.unidad4ej6.feature.insumo.controllers.post;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad4ej6.feature.insumo.dtos.request.MovimientoStockDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.MovimientoStockResponseDTO;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoMoverStockService;
import com.programacion4.unidad4ej6.config.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class InsumoMoverStockController {
    
    private final IInsumoMoverStockService insumoMoverStockService;

    @PostMapping("/{id}/stock")
    public ResponseEntity<BaseResponse<MovimientoStockResponseDTO>> moverStock(
        @PathVariable Long id,
        @Valid @RequestBody MovimientoStockDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(BaseResponse.ok(
            insumoMoverStockService.moverStock(id, dto), 
            "Movimiento de stock realizado correctamente"
            )
        );
    }
}
