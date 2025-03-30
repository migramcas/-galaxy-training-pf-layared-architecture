package com.migramcas.layaed.architecture.finsalud.controller.core.goals;

import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.CreateInvestmentGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.CreateSavingGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.HealthByGoalDto;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.FinancialHealth;
import com.migramcas.layaed.architecture.finsalud.exception.ConsultaNoAutorizadaException;
import com.migramcas.layaed.architecture.finsalud.exception.GoalNotFoundException;
import com.migramcas.layaed.architecture.finsalud.exception.SinTransaccionesRegistradasException;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import io.swagger.v3.oas.annotations.Operation;
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
    @PostMapping(value = ENDPOINT_SAVING_GOAL)
    ResponseEntity<CustomResponse<Goal>> createSavingGoal(
            @Valid @RequestBody CreateSavingGoalDto dto, HttpServletRequest request) throws ServiceException;

    @Operation(summary = "Registra una meta de inversión")
    @PostMapping(ENDPOINT_INVESTMENT_GOAL)
    ResponseEntity<CustomResponse<Goal>> createInvestmentGoal(@Valid @RequestBody CreateInvestmentGoalDto dto);

    @Operation(summary = "Calcular salud")
    @PostMapping(ENDPOINT_GOAL_HEALTH)
    ResponseEntity<CustomResponse<FinancialHealth>> calculateHealthByGoal(@Valid @RequestBody HealthByGoalDto dto,
                                                                          HttpServletRequest request) throws GoalNotFoundException, ConsultaNoAutorizadaException, SinTransaccionesRegistradasException;

}
