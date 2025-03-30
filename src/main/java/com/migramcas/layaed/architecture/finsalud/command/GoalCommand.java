package com.migramcas.layaed.architecture.finsalud.command;

import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalPriority;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class GoalCommand {

    private User user;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal totalAmount;

    private GoalType type;

    private GoalPriority priority;


}
