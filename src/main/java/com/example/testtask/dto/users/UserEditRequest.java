package com.example.testtask.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEditRequest {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private long dateOfBirth;
    private String password;
    private String passwordNew;
}
