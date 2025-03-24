package com.migramcas.layaed.architecture.finsalud.controller.core.goals;

import com.migramcas.layaed.architecture.finsalud.command.CreateGoalCommand;
import com.migramcas.layaed.architecture.finsalud.controller.base.BaseController;
import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.CreateInvestmentGoalDto;
import com.migramcas.layaed.architecture.finsalud.controller.dto.CreateSavingGoalDto;
import com.migramcas.layaed.architecture.finsalud.entity.core.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;
import com.migramcas.layaed.architecture.finsalud.service.base.ServiceException;
import com.migramcas.layaed.architecture.finsalud.service.core.goals.FinancialGoalTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoalControllerImpl extends BaseController implements GoalController {

    @Autowired
    private FinancialGoalTrackingService financialGoalTrackingService;

    @Override
    public ResponseEntity<CustomResponse<Goal>> createSavingGoal(CreateSavingGoalDto dto)
            throws ServiceException {
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
