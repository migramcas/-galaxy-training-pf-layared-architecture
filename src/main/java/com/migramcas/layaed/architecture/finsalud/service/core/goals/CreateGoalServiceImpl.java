package com.migramcas.layaed.architecture.finsalud.service.core.goals;

import com.migramcas.layaed.architecture.finsalud.command.GoalCommand;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.repository.mysql.GoalRepository;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateGoalServiceImpl implements CreateGoalService {

    GoalRepository goalRepository;

    @Autowired
    public CreateGoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public Goal execute(GoalCommand goalCommand) throws ServiceException {
        Goal goal = Goal.builder()
                .id(GoalId.of(goalRepository.getNextId()))
                .userId(goalCommand.getUser().getId())
                .startDate(goalCommand.getStartDate())
                .endDate(goalCommand.getEndDate())
                .totalAmount(goalCommand.getTotalAmount())
                .type(goalCommand.getType())
                .priority(goalCommand.getPriority())
                .active(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return goalRepository.save(goal);
    }


}
