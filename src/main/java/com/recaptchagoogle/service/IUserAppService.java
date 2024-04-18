package com.recaptchagoogle.service;

import com.recaptchagoogle.entities.UserApp;

import java.util.List;
import java.util.Optional;

public interface IUserAppService {

    List<UserApp> findAll();

    Optional<UserApp> findById(Long id);

    void saveUserApp(UserApp userApp);

    void deleteUserAppById(Long id);

}
