package com.programacion4.unidad4ej6.feature.insumo.controllers.delete;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoDeleteService;
import com.programacion4.unidad4ej6.config.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class InsumoDeleteController {
    private final IInsumoDeleteService insumoDeleteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteInsumo(
        @PathVariable Long id
    ) {
        insumoDeleteService.deleteInsumo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body(BaseResponse.ok(
            null, 
            "Insumo eliminado correctamente"
        ));
    }
}
