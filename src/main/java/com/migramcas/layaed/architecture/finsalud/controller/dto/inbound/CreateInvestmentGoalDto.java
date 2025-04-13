package com.migramcas.layaed.architecture.finsalud.controller.dto.inbound;

import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreateInvestmentGoalDto extends CreateGoalDto {

    private Integer type = GoalType.INVESTMENT.getId();

    @NotNull(message = "Los meses proyectados son requeridos")
    @Min(value = 1, message = "Debe proyectarse al menos un mes")
    @Max(value = 24, message = "La proyección máxima son 24 meses")
    protected Integer projectedMonths;

    @Min(value = 1, message = "La tasa anualizada debe ser mínimo 1%")
    @Max(value = 30, message = "La tasa máxima anulizada de rendimientos es máximo 30%")
    protected BigDecimal performacePercentage;

    public CreateInvestmentGoalDto() {
        super();
    }

    public Integer getType() {
        return type;
    }

    public Integer getProjectedMonths() {
        return projectedMonths;
    }

    public BigDecimal getPerformacePercentage() {
        return performacePercentage;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setProjectedMonths(Integer projectedMonths) {
        this.projectedMonths = projectedMonths;
    }

    public void setPerformacePercentage(BigDecimal performacePercentage) {
        this.performacePercentage = performacePercentage;
    }
}
