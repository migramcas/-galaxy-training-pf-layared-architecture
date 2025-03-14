package com.migramcas.layaed.architecture.finsalud.entity.core.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum GoalType {

    SAVING(1, "Ahorro"),
    INVESTMENT(2, "Inversión");

    private final Integer id;
    private final String description;

    GoalType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public static GoalType of(Integer id){
        for(GoalType val : GoalType.values()){
            if(Objects.equals(val.id, id)){
                return val;
            }
        }

        throw new IllegalArgumentException("El valor " + id + " es inválido");
    }
}
