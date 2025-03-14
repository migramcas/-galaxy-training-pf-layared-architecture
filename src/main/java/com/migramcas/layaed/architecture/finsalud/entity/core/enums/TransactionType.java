package com.migramcas.layaed.architecture.finsalud.entity.core.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum TransactionType {

    INCOME(1, "Ingreso"),
    EXPENSE(2, "Gasto");

    private final Integer id;
    private final String description;

    TransactionType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public static TransactionType of(Integer id){
        for(TransactionType val : TransactionType.values()){
            if(Objects.equals(val.id, id)){
                return val;
            }
        }

        throw new IllegalArgumentException("El valor " + id + " es inválido");
    }
}
