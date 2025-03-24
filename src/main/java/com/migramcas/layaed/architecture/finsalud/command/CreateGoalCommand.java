package com.migramcas.layaed.architecture.finsalud.command;

import com.migramcas.layaed.architecture.finsalud.entity.core.GoalId;
import com.migramcas.layaed.architecture.finsalud.entity.core.UserId;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalPriority;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class CreateGoalCommand {

    private UserId userId;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal totalAmount;

    private GoalType type;

    private GoalPriority priority;


}
