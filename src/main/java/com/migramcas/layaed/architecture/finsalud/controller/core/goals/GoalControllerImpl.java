package com.migramcas.layaed.architecture.finsalud.controller.core.goals;

import com.migramcas.layaed.architecture.finsalud.command.CreateGoalCommand;
import com.migramcas.layaed.architecture.finsalud.controller.base.BaseController;
import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.CreateInvestmentGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.CreateSavingGoalDto;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.service.core.goals.FinancialGoalTrackingService;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.migramcas.layaed.architecture.finsalud.controller.middleware.SessionMiddleware.SESSION_USER_PARAM;

@RestController
public class GoalControllerImpl extends BaseController implements GoalController {

    private FinancialGoalTrackingService financialGoalTrackingService;

    @Autowired
    public GoalControllerImpl(FinancialGoalTrackingService financialGoalTrackingService) {
        this.financialGoalTrackingService = financialGoalTrackingService;
    }

    @Override
    public ResponseEntity<CustomResponse<Goal>> createSavingGoal(CreateSavingGoalDto dto, HttpServletRequest request)
            throws ServiceException {
        User user = (User) request.getAttribute(SESSION_USER_PARAM);
        CreateGoalCommand cmd = CreateGoalCommand.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .type(GoalType.of(dto.getType()))
                .totalAmount(dto.getTotalAmount())
                .build();
        return success(financialGoalTrackingService.execute(cmd));
    }

    @Override
    public ResponseEntity<CustomResponse<Goal>> createInvestmentGoal(CreateInvestmentGoalDto dto) {
        return null;
    }

}
