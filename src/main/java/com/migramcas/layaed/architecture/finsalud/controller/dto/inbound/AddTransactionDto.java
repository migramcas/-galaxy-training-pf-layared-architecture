package com.migramcas.layaed.architecture.finsalud.controller.dto.inbound;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddTransactionDto {

    @NotNull(message = "El id de la meta es requerida")
    @Min(value = 1, message = "El id de la meta minimo es 1")
    private Integer goalId;

    @NotNull(message = "El tipo es requerido")
    @Min(value = 1, message = "Tipo inválido")
    @Max(value = 2, message = "Tipo inválido")
    private Integer type;

    @NotBlank(message = "Nombre de la meta es requerido")
    private String name;

    @NotNull(message = "El monto es requerido")
    @Min(value = 1, message = "El monto mínimo es de 1  peso")
    private BigDecimal amount;

}
