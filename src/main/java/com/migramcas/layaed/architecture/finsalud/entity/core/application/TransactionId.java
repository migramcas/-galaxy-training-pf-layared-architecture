package com.migramcas.layaed.architecture.finsalud.entity.core.application;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
public class TransactionId implements Serializable {

    @NonNull
    private Integer value;

    // Constructor
    public TransactionId(Integer value) {
        this.value = value;
    }

    protected TransactionId() {
    }

}
