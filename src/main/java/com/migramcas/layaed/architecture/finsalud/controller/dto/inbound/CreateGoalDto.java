package com.migramcas.layaed.architecture.finsalud.controller.dto.inbound;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.migramcas.layaed.architecture.finsalud.controller.utils.EndpointConstant.DATE_FORMAT;

public abstract  class CreateGoalDto {

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @DateTimeFormat(pattern = DATE_FORMAT)
    @NotNull(message = "La fecha de inicio es requerida")
    protected LocalDate startDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @DateTimeFormat(pattern = DATE_FORMAT)
    @NotNull(message = "La fecha de término es requerida")
    protected LocalDate endDate;

    @NotNull(message = "El monto total es requerido")
    @Min(value = 1, message = "El monto mínimo es de 1  peso")
    protected BigDecimal totalAmount;


    @NotNull(message = "La prioridad es requerida")
    @Min(value = 1, message = "La prioridad mínima es de 1")
    @Max(value = 4, message = "La prioridad máxima es 4")
    protected Integer priority;

    public CreateGoalDto() {
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
