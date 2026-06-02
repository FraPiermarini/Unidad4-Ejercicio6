package com.programacion4.unidad4ej6.Scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoUpdateDolarService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DolarScheduler {

    private final IInsumoUpdateDolarService insumoUpdateDolarService;

    @Scheduled(cron = "0 0 * * * MON-FRI")
    public void actualizarDolar() {
        System.out.println("Scheduler Ejecutado");
        insumoUpdateDolarService.actualizarPreciosPorDolar();
    }
}