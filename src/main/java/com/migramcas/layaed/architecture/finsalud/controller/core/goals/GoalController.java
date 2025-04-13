package com.migramcas.layaed.architecture.finsalud.controller.core.goals;

import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.CreateInvestmentGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.CreateSavingGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.HealthByGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.outbond.DetailInvestmentGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.outbond.DetailSavingGoal;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.FinancialHealth;
import com.migramcas.layaed.architecture.finsalud.service.exception.ConsultaNoAutorizadaException;
import com.migramcas.layaed.architecture.finsalud.service.exception.GoalNotFoundException;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import com.migramcas.layaed.architecture.finsalud.service.exception.SinTransaccionesRegistradasException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.migramcas.layaed.architecture.finsalud.controller.base.RestEndpoints.*;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public interface GoalController {

    @Operation(summary = "Registra una meta de ahorro")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Guardar nueva meta de ahorro exitosamente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al guardar una nueva meta",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}
            )
    })
    @PostMapping(value = ENDPOINT_SAVING_GOAL)
    ResponseEntity<CustomResponse<DetailSavingGoal>> createSavingGoal(
            @Valid @RequestBody CreateSavingGoalDto dto, HttpServletRequest request) throws ServiceException;

    @Operation(summary = "Registra una meta de inversión")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Guardar nueva meta de inversión exitosamente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al guardar una nueva meta de inversión",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}
            )
    })
    @PostMapping(ENDPOINT_INVESTMENT_GOAL)
    ResponseEntity<CustomResponse<DetailInvestmentGoalDto>> createInvestmentGoal(@Valid @RequestBody CreateInvestmentGoalDto dto,
                                                                                 HttpServletRequest request) throws ServiceException;

    @Operation(summary = "Calcular salud de una meta")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Calcular la salud por una meta",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al consultar la salud de una meta",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}
            )
    })
    @PostMapping(ENDPOINT_GOAL_HEALTH)
    ResponseEntity<CustomResponse<FinancialHealth>> calculateHealthByGoal(@Valid @RequestBody HealthByGoalDto dto,
                                                                          HttpServletRequest request) throws GoalNotFoundException, ConsultaNoAutorizadaException, SinTransaccionesRegistradasException;
}
