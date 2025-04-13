package com.migramcas.layaed.architecture.finsalud.controller.core.balance;

import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.service.core.dto.BalanceDTO;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.migramcas.layaed.architecture.finsalud.controller.base.RestEndpoints.ENDPOINT_MONTHLY_BALANCE;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public interface BalanceController {

    @Operation(summary = "Obtener el balance de gastos e ingresos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Consultar el balance del usuario para la fecha consultada",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BalanceDTO.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al consultar la información del de transacciones",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BalanceDTO.class))}
            )
    })
    @GetMapping(value = ENDPOINT_MONTHLY_BALANCE)
    ResponseEntity<CustomResponse<BalanceDTO>> getBalanceMonthly(HttpServletRequest request) throws ServiceException;

}
