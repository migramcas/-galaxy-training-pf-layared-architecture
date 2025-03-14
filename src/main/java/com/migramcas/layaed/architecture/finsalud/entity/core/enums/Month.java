package com.migramcas.layaed.architecture.finsalud.entity.core.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum Month {

    JANUARY(1, "Enero"),
    FEBRUARY(2, "Febrero"),
    MARCH(3, "Marzo"),
    APRIL(4, "Abril"),
    MAY(5, "Mayo"),
    JUNE(6, "Junio"),
    JULY(7, "Julio"),
    AUGUST(8, "Agosto"),
    SEPTEMBER(9, "Septiembre"),
    OCTOBER(10, "Octubre"),
    NOVEMBER(11, "Noviembre"),
    DECEMBER(12, "Diciembre");

    private final Integer id;
    private final String description;

    Month(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public static Month of(Integer id) {
        for (Month val : Month.values()) {
            if (Objects.equals(val.id, id)) {
                return val;
            }
        }

        throw new IllegalArgumentException("El valor " + id + " es inválido");
    }
}
