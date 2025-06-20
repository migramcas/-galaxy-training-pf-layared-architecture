package com.migramcas.layaed.architecture.finsalud.controller.core.goals;

import com.migramcas.layaed.architecture.finsalud.controller.base.BaseController;
import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.CreateInvestmentGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.CreateSavingGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.HealthByGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.outbond.DetailInvestmentGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.outbond.DetailSavingGoal;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.*;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.mapper.GenericMapper;
import com.migramcas.layaed.architecture.finsalud.service.command.CalculateHealthCommand;
import com.migramcas.layaed.architecture.finsalud.service.command.GoalCommand;
import com.migramcas.layaed.architecture.finsalud.service.core.finantialhealth.CalculateFinancialHealthByGoal;
import com.migramcas.layaed.architecture.finsalud.service.core.goals.CreateGoalService;
import com.migramcas.layaed.architecture.finsalud.service.exception.GoalNotFoundException;
import com.migramcas.layaed.architecture.finsalud.service.exception.NoTransactionsFoundException;
import com.migramcas.layaed.architecture.finsalud.service.exception.QueryNotAllowedException;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.migramcas.layaed.architecture.finsalud.controller.middleware.SessionMiddleware.SESSION_USER_PARAM;

@RestController
public class GoalControllerImpl extends BaseController implements GoalController {

    private final GenericMapper genericMapper;
    private final CreateGoalService createGoalService;
    private final CalculateFinancialHealthByGoal calculateFinancialHealthByGoal;

    @Autowired
    public GoalControllerImpl(CreateGoalService createGoalService, CalculateFinancialHealthByGoal calculateFinancialHealthByGoal) {
        this.genericMapper = new GenericMapper();
        this.createGoalService = createGoalService;
        this.calculateFinancialHealthByGoal = calculateFinancialHealthByGoal;
    }

    @Override
    public ResponseEntity<CustomResponse<DetailSavingGoal>> createSavingGoal(CreateSavingGoalDto dto,
                                                         HttpServletRequest request) throws ServiceException {

        User user = (User) request.getAttribute(SESSION_USER_PARAM);
        GoalCommand cmd = GoalCommand.builder()
                .type(GoalType.of(dto.getType()))
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .totalAmount(dto.getTotalAmount())
                .priority(GoalPriority.of(dto.getPriority()))
                .user(user)
                .build();

        Goal goalSaving = createGoalService.execute(cmd);
        return success(genericMapper.toMap(goalSaving, DetailSavingGoal.class));
    }

    @Override
    public ResponseEntity<CustomResponse<DetailInvestmentGoalDto>> createInvestmentGoal(CreateInvestmentGoalDto dto,
            HttpServletRequest request) throws ServiceException {
        User user = (User) request.getAttribute(SESSION_USER_PARAM);
        GoalCommand cmd = GoalCommand.builder()
                .type(GoalType.of(dto.getType()))
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .totalAmount(dto.getTotalAmount())
                .priority(GoalPriority.of(dto.getPriority()))
                .projectedMonths(dto.getProjectedMonths())
                .performacePercentage(dto.getPerformacePercentage())
                .user(user)
                .build();

        Goal investmentGoal = createGoalService.execute(cmd);
        return success(genericMapper.toMap(investmentGoal, DetailInvestmentGoalDto.class));
    }

    @Override
    public ResponseEntity<CustomResponse<FinancialHealth>> calculateHealthByGoal(
            HealthByGoalDto dto, HttpServletRequest request)
            throws GoalNotFoundException, QueryNotAllowedException, NoTransactionsFoundException {

        CalculateHealthCommand command = CalculateHealthCommand.builder()
                .goalId(GoalId.of(dto.getGoalId()))
                .user((User) request.getAttribute(SESSION_USER_PARAM))
                .build();

        return success(calculateFinancialHealthByGoal.execute(command));
    }

}
