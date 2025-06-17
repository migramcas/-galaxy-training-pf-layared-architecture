package com.migramcas.layaed.architecture.finsalud.controller.dto.outbond;

import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalPriority;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DetailSavingGoal {

    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalAmount;
    private GoalPriority priority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
