package com.migramcas.layaed.architecture.finsalud.entity.core.application;

import com.migramcas.layaed.architecture.finsalud.entity.base.BaseEntity;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalPriority;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@SuperBuilder
@Table(name = "Goal")
@Entity
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Goal extends BaseEntity {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "projectedMonths")
    private Integer projectedMonths;

    @Column(name = "performacePercentage")
    private BigDecimal performacePercentage;

    protected Goal() {
    }
}
