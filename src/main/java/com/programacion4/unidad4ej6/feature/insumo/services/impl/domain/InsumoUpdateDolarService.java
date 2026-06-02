package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.programacion4.unidad4ej6.feature.insumo.dtos.response.DolarOficialDto;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoUpdateDolarService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsumoUpdateDolarService implements IInsumoUpdateDolarService {

    private final IInsumoRepository insumoRepository;
    private final RestTemplate restTemplate;

    private static final String URL_DOLAR =
            "https://dolarapi.com/v1/dolares/oficial";

    @Override
    public void actualizarPreciosPorDolar() {

        DolarOficialDto dolarActual =
                restTemplate.getForObject(
                        URL_DOLAR,
                        DolarOficialDto.class
                );

        if (dolarActual == null || dolarActual.getVenta() == null) {
            throw new RuntimeException(
                    "No se pudo obtener la cotización del dólar"
            );
        }

        Double nuevoValorDolar = dolarActual.getVenta();

        Iterable<Insumo> insumos = insumoRepository.findAll();

        for (Insumo insumo : insumos) {

            if (!nuevoValorDolar.equals(insumo.getValorDolarReferencia())) {

                insumo.setValorDolarReferencia(nuevoValorDolar);

                insumo.setPrecioEnPesos(
                        insumo.getPrecioEnDolares() * nuevoValorDolar
                );

                insumoRepository.save(insumo);
            }
        }
    }
}