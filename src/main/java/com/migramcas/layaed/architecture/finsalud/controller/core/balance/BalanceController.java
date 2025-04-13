package com.migramcas.layaed.architecture.finsalud.controller.core.balance;

import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.service.core.dto.BalanceDTO;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.migramcas.layaed.architecture.finsalud.controller.base.RestEndpoints.ENDPOINT_MONTHLY_BALANCE;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public interface BalanceController {

    @Operation(summary = "Obtener el blance de gastos e ingresos")
    @GetMapping(value = ENDPOINT_MONTHLY_BALANCE)
    ResponseEntity<CustomResponse<BalanceDTO>> getBalanceMonthly(HttpServletRequest request) throws ServiceException;

}
