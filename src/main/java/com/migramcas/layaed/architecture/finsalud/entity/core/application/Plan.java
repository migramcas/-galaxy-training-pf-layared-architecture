package com.migramcas.layaed.architecture.finsalud.entity.core.application;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Plan {

    @Embedded
    Goal goal;

    @Embedded
    List<Transaction> transactions;

    protected Plan() {
    }

}
