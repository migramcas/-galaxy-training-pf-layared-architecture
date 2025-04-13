package com.migramcas.layaed.architecture.finsalud.controller.core.balance;

import com.migramcas.layaed.architecture.finsalud.controller.base.BaseController;
import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.service.core.balance.CalculateBalanceByDate;
import com.migramcas.layaed.architecture.finsalud.service.core.dto.BalanceDTO;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.migramcas.layaed.architecture.finsalud.controller.middleware.SessionMiddleware.SESSION_USER_PARAM;

@RestController
public class BalanceControllerImpl extends BaseController implements BalanceController {

    CalculateBalanceByDate calculateBalanceByDate;

    @Autowired
    public BalanceControllerImpl(CalculateBalanceByDate calculateBalanceByDate) {
        this.calculateBalanceByDate = calculateBalanceByDate;
    }

    @Override
    public ResponseEntity<CustomResponse<BalanceDTO>> getBalanceMonthly(HttpServletRequest request)
            throws ServiceException {
        User user = (User) request.getAttribute(SESSION_USER_PARAM);
        return success(calculateBalanceByDate.execute(user, LocalDate.now()));
    }

}
