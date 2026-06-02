package com.programacion4.unidad4ej6.feature.insumo.controllers.put;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoRecoveryService;
import com.programacion4.unidad4ej6.config.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class InsumoRecoveryController {

    private final IInsumoRecoveryService insumoRecoveryService;

    @PutMapping("/{id}/recovery")
    public ResponseEntity<BaseResponse<Void>> recoveryInsumo(
        @PathVariable Long id
    ) {
        insumoRecoveryService.recoveryInsumo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body(BaseResponse.ok(
            null, 
            "Insumo recuperado correctamente"
        ));
    }
}
