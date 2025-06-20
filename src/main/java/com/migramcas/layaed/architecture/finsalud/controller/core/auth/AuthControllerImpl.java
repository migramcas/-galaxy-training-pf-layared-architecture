package com.migramcas.layaed.architecture.finsalud.controller.core.auth;

import com.migramcas.layaed.architecture.finsalud.controller.base.BaseController;
import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.LoginDto;
import com.migramcas.layaed.architecture.finsalud.service.core.auth.EnableAccountService;
import com.migramcas.layaed.architecture.finsalud.service.core.auth.LoginService;
import com.migramcas.layaed.architecture.finsalud.service.exception.AccountDisabledException;
import com.migramcas.layaed.architecture.finsalud.service.exception.AccountEnabledPreviouslyException;
import com.migramcas.layaed.architecture.finsalud.service.exception.InvalidLoginException;
import com.migramcas.layaed.architecture.finsalud.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl extends BaseController implements AuthController {

    private final EnableAccountService enableAccountService;
    private final LoginService<LoginDto, String> loginService;

    @Autowired
    public AuthControllerImpl(EnableAccountService enableAccountService, LoginService loginService) {
        this.enableAccountService = enableAccountService;
        this.loginService = loginService;
    }

    @Override
    public ResponseEntity<CustomResponse<String>> activateAccount(LoginDto dto)
            throws UserNotFoundException, AccountEnabledPreviouslyException {
        enableAccountService.execute(dto.getEmail(), dto.getPassword());
        return success("");
    }

    @Override
    public ResponseEntity<CustomResponse<String>> loginUser(LoginDto dto)
            throws UserNotFoundException, AccountDisabledException, InvalidLoginException {
        String token = loginService.execute(dto);
        return success(token);
    }

}
