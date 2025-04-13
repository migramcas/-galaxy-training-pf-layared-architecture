package com.migramcas.layaed.architecture.finsalud.controller.dto.inbound;

import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;

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
