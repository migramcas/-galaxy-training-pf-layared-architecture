package com.migramcas.layaed.architecture.finsalud.controller.core.auth;

import com.migramcas.layaed.architecture.finsalud.controller.base.BaseController;
import com.migramcas.layaed.architecture.finsalud.controller.base.CustomResponse;
import com.migramcas.layaed.architecture.finsalud.controller.dto.LoginDto;
import com.migramcas.layaed.architecture.finsalud.exception.UserNotFoundException;
import com.migramcas.layaed.architecture.finsalud.service.core.auth.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl extends BaseController implements AuthController {

    private LoginService<LoginDto, String> loginService;

    @Autowired
    public AuthControllerImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public ResponseEntity<CustomResponse<String>> loginUser(LoginDto dto) throws UserNotFoundException {
        String token = loginService.execute(dto);
        return success(token);
    }

}
