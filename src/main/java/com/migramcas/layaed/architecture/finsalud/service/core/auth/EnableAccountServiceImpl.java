package com.migramcas.layaed.architecture.finsalud.service.core.auth;

import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserControl;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.UserControlId;
import com.migramcas.layaed.architecture.finsalud.repository.sqlserver.UserControlRepository;
import com.migramcas.layaed.architecture.finsalud.repository.sqlserver.UserRepository;
import com.migramcas.layaed.architecture.finsalud.service.exception.AccountEnabledPreviouslyException;
import com.migramcas.layaed.architecture.finsalud.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EnableAccountServiceImpl implements EnableAccountService {

    private static final String MSG_USER_NOT_FOUND = "El usuario con email %s no existe";
    private static final String MSG_ACCOUNT_ENABLED_PREV = "La cuenta fue habilitada previamente";

    private final UserRepository userRepository;
    private final UserControlRepository userControlRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EnableAccountServiceImpl(UserRepository userRepository, UserControlRepository userControlRepository,
                                    PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userControlRepository = userControlRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void execute(String email, String password) throws UserNotFoundException, AccountEnabledPreviouslyException {
        User user = userRepository.getByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(MSG_USER_NOT_FOUND));
        Optional<UserControl> metadataAccount = userControlRepository.getUserById(user.getId());

        if (metadataAccount.isPresent()) {
            throw new AccountEnabledPreviouslyException(MSG_ACCOUNT_ENABLED_PREV);
        }

        LocalDateTime now = LocalDateTime.now();
        UserControl newActivationAccount = UserControl.builder()
                .id(UserControlId.of(userControlRepository.getNextId()))
                .userId(user.getId())
                .password(passwordEncoder.encode(password))
                .activationAccountDate(now)
                .createdAt(now)
                .updatedAt(now)
                .active(true)
                .build();

        userControlRepository.save(newActivationAccount);
    }

}
