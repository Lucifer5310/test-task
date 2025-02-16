package com.example.testtask.dto.authenticationAuthorisation;

import lombok.Data;

@Data
public class SignUpRequest {

    private String firstName;
    private String lastName;
    private String email;
    private long dateOfBirth;
    private String username;
    private String password;
}
