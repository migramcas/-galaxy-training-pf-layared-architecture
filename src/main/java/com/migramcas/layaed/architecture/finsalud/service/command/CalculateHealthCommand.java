package com.migramcas.layaed.architecture.finsalud.service.command;

import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CalculateHealthCommand {

    private User user;
    private GoalId goalId;

}
