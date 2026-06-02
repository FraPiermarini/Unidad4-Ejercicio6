package com.programacion4.unidad4ej6.Insumo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.programacion4.unidad4ej6.feature.insumo.dtos.response.DolarOficialDto;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.services.impl.domain.InsumoUpdateDolarService;


@ExtendWith(MockitoExtension.class)
   class InsumoUpdateDolarServiceTest {

    @Mock
    private IInsumoRepository insumoRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private InsumoUpdateDolarService service;

    @Test
    void debeActualizarInsumoCuandoCambiaElDolar() {

        Insumo insumo = Insumo.builder()
                .id(1L)
                .nombre("Monitor")
                .codigoInterno("LUMI-0001")
                .precioEnDolares(100.0)
                .valorDolarReferencia(1000.0)
                .precioEnPesos(100000.0)
                .activo(true)
                .stockActual(0L)
                .build();

        DolarOficialDto dolar =
                new DolarOficialDto(
                        1400.0,
                        1450.0,
                        "oficial",
                        "Oficial",
                        "USD",
                        "2026"
                );

        when(restTemplate.getForObject(
                anyString(),
                eq(DolarOficialDto.class)))
                .thenReturn(dolar);

        when(insumoRepository.findAll())
                .thenReturn(List.of(insumo));

        service.actualizarPreciosPorDolar();

        assertEquals(
                1450.0,
                insumo.getValorDolarReferencia()
        );

        assertEquals(
                145000.0,
                insumo.getPrecioEnPesos()
        );

        verify(insumoRepository)
                .save(insumo);
    }

@Test
void noDebeActualizarSiElDolarEsElMismo() {

    Insumo insumo = Insumo.builder()
            .id(1L)
            .nombre("Monitor")
            .codigoInterno("LUMI-0001")
            .precioEnDolares(100.0)
            .valorDolarReferencia(1450.0)
            .precioEnPesos(145000.0)
            .activo(true)
            .stockActual(0L)
            .build();

    DolarOficialDto dolar =
            new DolarOficialDto(
                    1400.0,
                    1450.0,
                    "oficial",
                    "Oficial",
                    "USD",
                    "2026"
            );

    when(restTemplate.getForObject(
            anyString(),
            eq(DolarOficialDto.class)))
            .thenReturn(dolar);

    when(insumoRepository.findAll())
            .thenReturn(List.of(insumo));

    service.actualizarPreciosPorDolar();

    verify(insumoRepository, never())
            .save(any(Insumo.class));
}
}



