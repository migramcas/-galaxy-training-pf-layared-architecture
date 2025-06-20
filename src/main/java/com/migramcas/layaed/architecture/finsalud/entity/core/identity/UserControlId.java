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
public class UserControlId implements Serializable {

    @NotNull
    @Column(name = "user_control_id")
    private Integer value;

    protected UserControlId() {
    }

    public UserControlId(Integer value) {
        this.value = value;
    }

    public static UserControlId of(Integer value) {
        return new UserControlId(value);
    }

}
