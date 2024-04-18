package com.recaptchagoogle.controller.response;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
public class ResponseGoogleApi {

    private Boolean success;
    private String challenge_ts;
    private String hostname;
    private Double score;
    private String action;

}
