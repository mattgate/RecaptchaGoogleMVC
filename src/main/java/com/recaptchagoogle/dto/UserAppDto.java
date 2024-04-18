package com.recaptchagoogle.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAppDto {
    private String name;
    private String lastname;
    private Integer age;
}
