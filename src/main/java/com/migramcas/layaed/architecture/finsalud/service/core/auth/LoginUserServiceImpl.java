package com.migramcas.layaed.architecture.finsalud.service.core.auth;

import com.migramcas.layaed.architecture.finsalud.controller.dto.LoginDto;
import com.migramcas.layaed.architecture.finsalud.entity.core.User;
import com.migramcas.layaed.architecture.finsalud.entity.core.UserId;
import com.migramcas.layaed.architecture.finsalud.exception.UserNotFoundException;
import com.migramcas.layaed.architecture.finsalud.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginService<LoginDto, String> {

    UserRepository userRepository;
    TokenManager tokenManager;

    public LoginUserServiceImpl(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public String execute(LoginDto dto) throws UserNotFoundException {
//        User user = userRepository
//                .getByUserName(dto.getUsername())
//                .orElseThrow(()-> new UserNotFoundException("Usuario no encontrado"));

        User user = User.builder()
                .id(UserId.of(1))
                .userName("migramcas")
                .name("Miguel")
                .firstLastName("Pérez")
                .secondLastName("Juárez")
                .build();

        return tokenManager.createToken(user);
    }

}
