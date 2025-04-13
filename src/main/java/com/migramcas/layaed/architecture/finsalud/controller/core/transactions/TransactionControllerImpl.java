package com.migramcas.layaed.architecture.finsalud.controller.core.transactions;

import com.migramcas.layaed.architecture.finsalud.command.TransactionCommand;
import com.migramcas.layaed.architecture.finsalud.controller.base.BaseController;
import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.AddTransactionDto;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Transaction;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.TransactionId;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.TransactionType;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.service.core.transaction.TransactionService;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.migramcas.layaed.architecture.finsalud.controller.middleware.SessionMiddleware.SESSION_USER_PARAM;

@RestController
public class TransactionControllerImpl extends BaseController implements TransactionController {

    TransactionService<TransactionCommand, Transaction, TransactionId> transactionService;

    @Autowired
    public TransactionControllerImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ResponseEntity<CustomResponse<Transaction>> registerTransaction(AddTransactionDto dto, HttpServletRequest request) throws ServiceException {
        User user = (User) request.getAttribute(SESSION_USER_PARAM);
        TransactionCommand command = TransactionCommand.builder()
                .goalId(GoalId.of(dto.getGoalId()))
                .type(TransactionType.of(dto.getType()))
                .name(dto.getName())
                .amount(dto.getAmount())
                .user(user)
                .build();
        return success(transactionService.add(command));
    }

}
