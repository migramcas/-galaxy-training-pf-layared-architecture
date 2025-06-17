package com.migramcas.layaed.architecture.finsalud.entity.core.application;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum GoalPriority {

    LOW(1, "Baja"),
    MEDIUM(2, "Media"),
    HIGH(3, "Alta"),
    CRITICAL(4, "Crítica");

    private final Integer id;
    private final String description;

    GoalPriority(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public static GoalPriority of(Integer id) {
        for (GoalPriority val : GoalPriority.values()) {
            if (Objects.equals(val.id, id)) {
                return val;
            }
        }

        throw new IllegalArgumentException("El valor " + id + " es inválido");
    }
}
