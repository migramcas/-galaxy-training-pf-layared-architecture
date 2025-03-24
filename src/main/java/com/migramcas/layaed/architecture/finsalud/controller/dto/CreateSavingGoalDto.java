package com.migramcas.layaed.architecture.finsalud.controller.dto;

import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateSavingGoalDto extends  CreateGoalDto {

    public CreateSavingGoalDto() {
        super();
    }

    private Integer type = GoalType.SAVING.getId();

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
