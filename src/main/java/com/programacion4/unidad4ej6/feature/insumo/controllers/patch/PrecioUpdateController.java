package com.programacion4.unidad4ej6.feature.insumo.controllers.patch;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad4ej6.feature.insumo.dtos.request.PrecioUpdateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoUpdatePrecioService;

import com.programacion4.unidad4ej6.config.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class PrecioUpdateController {

    private final IInsumoUpdatePrecioService insumoUpdatePrecioService;

    @PatchMapping("/{id}/precio")
    public ResponseEntity<BaseResponse<InsumoResponseDTO>> updatePrecio(
        @PathVariable Long id,
        @Valid @RequestBody PrecioUpdateDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(
            BaseResponse.ok(
                insumoUpdatePrecioService.updatePrecio(id, dto), 
                "Precio actualizado correctamente"
            )
        );
    }

}
