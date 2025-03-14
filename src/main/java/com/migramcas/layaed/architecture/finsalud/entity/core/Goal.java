package com.migramcas.layaed.architecture.finsalud.entity.core;

import com.migramcas.layaed.architecture.finsalud.entity.base.Entity;
import com.migramcas.layaed.architecture.finsalud.entity.core.Enum.GoalPriority;
import com.migramcas.layaed.architecture.finsalud.entity.core.Enum.GoalType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
public class Goal extends Entity {

    private GoalId id;

    private UserId userId;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal totalAmount;

    private GoalType type;

    private GoalPriority priority;

}
