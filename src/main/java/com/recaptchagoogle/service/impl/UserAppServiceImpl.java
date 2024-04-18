package com.recaptchagoogle.service.impl;

import com.recaptchagoogle.entities.UserApp;
import com.recaptchagoogle.persistence.IUserAppRepository;
import com.recaptchagoogle.service.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAppServiceImpl implements IUserAppService {

    @Autowired
    IUserAppRepository userAppRepository;

    @Override
    public List<UserApp> findAll() {
        return userAppRepository.findAll();
    }

    @Override
    public Optional<UserApp> findById(Long id) {
        return userAppRepository.findById(id);
    }

    @Override
    public void saveUserApp(UserApp userApp) {
        userAppRepository.save(userApp);
    }

    @Override
    public void deleteUserAppById(Long id) {
        userAppRepository.deleteById(id);
    }
}
