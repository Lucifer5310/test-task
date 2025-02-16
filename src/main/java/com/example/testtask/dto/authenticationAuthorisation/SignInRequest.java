package com.example.testtask.dto.authenticationAuthorisation;

import lombok.Data;

@Data
public class SignInRequest {

    private String username;
    private String password;
}
