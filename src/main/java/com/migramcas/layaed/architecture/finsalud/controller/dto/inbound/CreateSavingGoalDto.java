package com.migramcas.layaed.architecture.finsalud.controller.dto.inbound;

import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalType;
import lombok.Getter;

@Getter
public class CreateSavingGoalDto extends  CreateGoalDto {

    public CreateSavingGoalDto() {
        super();
    }

    private Integer type = GoalType.SAVING.getId();

    public void setType(Integer type) {
        this.type = type;
    }
}
