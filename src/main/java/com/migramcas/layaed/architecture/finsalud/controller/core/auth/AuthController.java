package com.migramcas.layaed.architecture.finsalud.controller.core.auth;

import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.LoginDto;
import com.migramcas.layaed.architecture.finsalud.service.exception.UserNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.migramcas.layaed.architecture.finsalud.controller.base.RestEndpoints.ENDPOINT_AUTH_PREFIX;
import static com.migramcas.layaed.architecture.finsalud.controller.base.RestEndpoints.ENDPOINT_LOGIN;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = ENDPOINT_AUTH_PREFIX)
public interface AuthController {

    @Operation(summary = "Iniciar sesión")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Token de acceso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}
            )
    })
    @PostMapping(value = ENDPOINT_LOGIN)
    ResponseEntity<CustomResponse<String>> loginUser(@Valid @RequestBody LoginDto dto) throws UserNotFoundException;

}
