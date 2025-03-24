package com.migramcas.layaed.architecture.finsalud.controller.core.goals;

import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.CreateInvestmentGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.CreateSavingGoalDto;
import com.migramcas.layaed.architecture.finsalud.entity.core.Goal;
import com.migramcas.layaed.architecture.finsalud.service.base.ServiceException;
import com.migramcas.layaed.architecture.finsalud.service.core.goals.FinancialGoalTrackingService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.migramcas.layaed.architecture.finsalud.controller.base.RestEndpoints.ENDPOINT_INVESTMENT_GOAL;
import static com.migramcas.layaed.architecture.finsalud.controller.base.RestEndpoints.ENDPOINT_SAVING_GOAL;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public interface GoalController {

    @Operation(summary = "Registra una meta de ahorro")
    @PostMapping(value = ENDPOINT_SAVING_GOAL)
    ResponseEntity<CustomResponse<Goal>> createSavingGoal(@Valid @RequestBody CreateSavingGoalDto dto) throws ServiceException;


    @Operation(summary = "Registra una meta de inversión")
    @PostMapping(ENDPOINT_INVESTMENT_GOAL)
    ResponseEntity<CustomResponse<Goal>> createInvestmentGoal(@Valid @RequestBody CreateInvestmentGoalDto dto);

}
