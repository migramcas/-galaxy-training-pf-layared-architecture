package com.migramcas.layaed.architecture.finsalud.entity.core.Enum;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum FinancialHealth {

    CRITICAL(1, "Crítica"),
    POOR(2, "Pobre"),
    FAIR(3, "Aceptable"),
    GOOD(4, "Buena"),
    EXCELLENT(5, "Excelente");

    private final Integer id;
    private final String description;

    FinancialHealth(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public static FinancialHealth of(Integer id){
        for(FinancialHealth val : FinancialHealth.values()){
            if(Objects.equals(val.id, id)){
                return val;
            }
        }

        throw new IllegalArgumentException("El valor " + id + " es inválido");
    }
}
