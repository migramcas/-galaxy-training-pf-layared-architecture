package com.migramcas.layaed.architecture.finsalud.entity.core.application;

import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalPriority;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.BaseEntity;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
@Table(name = "Goal")
@Entity
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Goal extends BaseEntity {

    @Id
    private GoalId id;

    @Column(name = "user_id")
    private UserId userId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "type")
    private GoalType type;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private GoalPriority priority;

    protected Goal() {
    }
}
