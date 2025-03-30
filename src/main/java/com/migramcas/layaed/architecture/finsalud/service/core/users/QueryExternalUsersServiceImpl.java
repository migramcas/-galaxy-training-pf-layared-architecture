package com.migramcas.layaed.architecture.finsalud.service.core.users;

import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.repository.restTemplate.ExternalUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class QueryExternalUsersServiceImpl implements QueryExternalUsersService {

    ExternalUsersRepository externalUsersRepository;

    @Autowired
    public QueryExternalUsersServiceImpl(ExternalUsersRepository externalUsersRepository) {
        this.externalUsersRepository = externalUsersRepository;
    }

    @Override
    public Set<User> getAll() {
        return Arrays.stream(externalUsersRepository
                        .getAllUsers())
                .map(User::of)
                .collect(toSet());
    }

}
