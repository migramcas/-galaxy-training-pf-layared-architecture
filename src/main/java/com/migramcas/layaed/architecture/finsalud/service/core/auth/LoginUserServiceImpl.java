package com.migramcas.layaed.architecture.finsalud.service.core.auth;

import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.LoginDto;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.exception.UserNotFoundException;
import com.migramcas.layaed.architecture.finsalud.repository.sqlserver.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginService<LoginDto, String> {

    UserRepository userRepository;
    TokenManager tokenManager;

    public LoginUserServiceImpl(UserRepository userRepository, TokenManager tokenManager) {
        this.userRepository = userRepository;
        this.tokenManager = tokenManager;
    }

    @Override
    public String execute(LoginDto dto) throws UserNotFoundException {
        User user = userRepository
                .getByEmail(dto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        return tokenManager.createToken(user);
    }

}
