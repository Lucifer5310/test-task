package com.example.testtask.dto.users;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserGetResponse {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private long dateOfBirth;
}
