package com.migramcas.layaed.architecture.finsalud.entity.core.application;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
@EqualsAndHashCode
public class GoalId implements Serializable {

    @Column(name = "goal_id")
    private Integer value;

    protected GoalId() {
    }

    protected GoalId(Integer value) {
        this.value = value;
    }

    public static GoalId of(Integer id) {
        return new GoalId(id);
    }
}
