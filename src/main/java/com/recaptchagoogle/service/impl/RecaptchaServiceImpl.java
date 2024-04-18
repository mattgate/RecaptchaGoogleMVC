package com.recaptchagoogle.service.impl;

import com.recaptchagoogle.controller.response.ResponseGoogleApi;
import com.recaptchagoogle.service.IRecaptchaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RecaptchaServiceImpl implements IRecaptchaService {

    private String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";

    private final String SECRET_KEY = "";

    @Override
    public boolean validateRecaptcha(String captcha) {

        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> requestGoogleApi = new LinkedMultiValueMap<>();

        requestGoogleApi.add("secret", SECRET_KEY);
        requestGoogleApi.add("response", captcha);

        ResponseGoogleApi responseGoogleApi = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, requestGoogleApi, ResponseGoogleApi.class);

        if(responseGoogleApi == null){
            return false;
        }else {
            return Boolean.TRUE.equals(responseGoogleApi.getSuccess());
        }

    }
}
