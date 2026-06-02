package com.programacion4.unidad4ej6.feature.insumo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "insumos")
@Data
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String codigoInterno;

    @Column(nullable = false)
    private Long stockActual = 0L;

    @Column(nullable = false)
    private Boolean activo = true;

    @Column(nullable = false)
    private Double precioEnDolares;

    @Column(nullable = false)
    private Double valorDolarReferencia;

    @Column(nullable = false)
    private Double precioEnPesos;

    public void changeStatus() {
        this.activo = !this.activo;
    }
}
