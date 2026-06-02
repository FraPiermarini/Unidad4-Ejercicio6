package com.programacion4.unidad4ej6.feature.insumo.controllers.post;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad4ej6.feature.insumo.dtos.request.InsumoCreateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoCreateService;
import com.programacion4.unidad4ej6.config.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class InsumoCreateController {

    private final IInsumoCreateService insumoCreateService;

    @PostMapping
    public ResponseEntity<BaseResponse<InsumoResponseDTO>> createInsumo(
        @Valid @RequestBody InsumoCreateDTO dto
    ) {
        InsumoResponseDTO insumoResponseDTO = insumoCreateService.createInsumo(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            BaseResponse.ok(
                insumoResponseDTO, 
                "Insumo creado correctamente"
            )
        );
    }
}
