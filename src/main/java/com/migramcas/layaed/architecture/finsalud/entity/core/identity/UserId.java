package com.migramcas.layaed.architecture.finsalud.entity.core.identity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
@EqualsAndHashCode
public class UserId implements Serializable {

    @NotNull
    @Column(name = "user_id")
    private Integer value;

    protected UserId() {
    }

    public UserId(Integer value) {
        this.value = value;
    }

    public static UserId of(Integer value) {
        return new UserId(value);
    }

}
