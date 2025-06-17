package com.migramcas.layaed.architecture.finsalud.repository.restTemplate;

import com.migramcas.layaed.architecture.finsalud.repository.projection.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ExternalUsersRepositoryImpl implements ExternalUsersRepository {

    @Value("${ws.external.api.uri.base}")
    private String baseURI;

    @Value("${ws.external.api.uri.users}")
    private String usersEndpoint;

    private final RestTemplate restTemplate;

    @Autowired
    public ExternalUsersRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDto[] getAllUsers() {
        String url = baseURI + usersEndpoint;
        return restTemplate.getForObject(url, UserDto[].class);
    }

}
