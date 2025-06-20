package com.migramcas.layaed.architecture.finsalud.service.core.auth;

import com.migramcas.layaed.architecture.finsalud.controller.dto.inbound.LoginDto;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserControl;
import com.migramcas.layaed.architecture.finsalud.repository.sqlserver.UserControlRepository;
import com.migramcas.layaed.architecture.finsalud.repository.sqlserver.UserRepository;
import com.migramcas.layaed.architecture.finsalud.service.exception.AccountDisabledException;
import com.migramcas.layaed.architecture.finsalud.service.exception.InvalidLoginException;
import com.migramcas.layaed.architecture.finsalud.service.exception.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginService<LoginDto, String> {

    private static final String MSG_ACCOUNT_DISABLED = "La cuenta no ha sido habilitada por el usuario";
    private static final String MSG_INVALID_LOGIN = "El usuario o contraseña no son válidos";

    private final UserRepository userRepository;
    private final UserControlRepository userControlRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenManager tokenManager;

    public LoginUserServiceImpl(UserRepository userRepository,
        UserControlRepository userControlRepository, PasswordEncoder passwordEncoder, TokenManager tokenManager) {
        this.userRepository = userRepository;
        this.userControlRepository = userControlRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenManager = tokenManager;
    }

    @Override
    public String execute(LoginDto dto) throws UserNotFoundException, AccountDisabledException, InvalidLoginException {
        User user = userRepository
                .getByEmail(dto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        UserControl metadataUser = userControlRepository.getUserById(user.getId())
                .orElseThrow(()->new AccountDisabledException(MSG_ACCOUNT_DISABLED));

        if(!isValidPassword(dto.getPassword(), metadataUser.getPassword())){
            throw new InvalidLoginException(MSG_INVALID_LOGIN);
        }

        return tokenManager.createToken(user);
    }

    private boolean isValidPassword(String inputPass, String hashedPass){
        return passwordEncoder.matches(inputPass, hashedPass);
    }

}
