package com.migramcas.layaed.architecture.finsalud.controller.core.goals;

import com.migramcas.layaed.architecture.finsalud.command.CalculateHealthCommand;
import com.migramcas.layaed.architecture.finsalud.command.GoalCommand;
import com.migramcas.layaed.architecture.finsalud.controller.base.BaseController;
import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.CreateInvestmentGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.CreateSavingGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.HealthByGoalDto;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.FinancialHealth;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.exception.ConsultaNoAutorizadaException;
import com.migramcas.layaed.architecture.finsalud.exception.GoalNotFoundException;
import com.migramcas.layaed.architecture.finsalud.exception.SinTransaccionesRegistradasException;
import com.migramcas.layaed.architecture.finsalud.service.core.finantialhealth.CalculateFinancialHealthByGoal;
import com.migramcas.layaed.architecture.finsalud.service.core.goals.CreateGoalService;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.migramcas.layaed.architecture.finsalud.controller.middleware.SessionMiddleware.SESSION_USER_PARAM;

@RestController
public class GoalControllerImpl extends BaseController implements GoalController {

    private CreateGoalService createGoalService;
    private CalculateFinancialHealthByGoal calculateFinancialHealthByGoal;

    @Autowired
    public GoalControllerImpl(CreateGoalService createGoalService, CalculateFinancialHealthByGoal calculateFinancialHealthByGoal) {
        this.createGoalService = createGoalService;
        this.calculateFinancialHealthByGoal = calculateFinancialHealthByGoal;
    }

    @Override
    public ResponseEntity<CustomResponse<Goal>> createSavingGoal(CreateSavingGoalDto dto, HttpServletRequest request)
            throws ServiceException {
        User user = (User) request.getAttribute(SESSION_USER_PARAM);
        GoalCommand cmd = GoalCommand.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .type(GoalType.of(dto.getType()))
                .totalAmount(dto.getTotalAmount())
                .user(user)
                .build();
        return success(createGoalService.execute(cmd));
    }

    @Override
    public ResponseEntity<CustomResponse<Goal>> createInvestmentGoal(CreateInvestmentGoalDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<CustomResponse<FinancialHealth>> calculateHealthByGoal(HealthByGoalDto dto, HttpServletRequest request)
            throws GoalNotFoundException, ConsultaNoAutorizadaException, SinTransaccionesRegistradasException {
        CalculateHealthCommand command = CalculateHealthCommand.builder()
                .goalId(GoalId.of(dto.getGoalId()))
                .user((User) request.getAttribute(SESSION_USER_PARAM))
                .build();
        return success(calculateFinancialHealthByGoal.execute(command));
    }

}
