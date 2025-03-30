package com.migramcas.layaed.architecture.finsalud.controller.core.auth;

import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.LoginDto;
import com.migramcas.layaed.architecture.finsalud.exception.UserNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.migramcas.layaed.architecture.finsalud.controller.base.RestEndpoints.ENDPOINT_AUTH_PREFIX;
import static com.migramcas.layaed.architecture.finsalud.controller.base.RestEndpoints.ENDPOINT_LOGIN;

@RequestMapping(ENDPOINT_AUTH_PREFIX)
public interface AuthController {

    @Operation(summary = "Iniciar sesión")
    @PostMapping(value = ENDPOINT_LOGIN)
    ResponseEntity<CustomResponse<String>> loginUser(LoginDto dto) throws UserNotFoundException;

}
