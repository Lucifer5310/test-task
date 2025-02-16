package com.example.testtask.facade;

import com.example.testtask.dao.entity.Users;
import com.example.testtask.dto.users.UserEditRequest;
import com.example.testtask.dto.users.UserEditResponse;
import com.example.testtask.dto.users.UserGetResponse;
import com.example.testtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserEditResponse saveEditRequest(UserEditRequest userEditRequest, long id) throws Exception {
        Users users = userService.findById(id);

        users.setUsername(userEditRequest.getUsername());
        users.setEmail(userEditRequest.getEmail());
        users.setFirstName(userEditRequest.getFirstName());
        users.setLastName(userEditRequest.getLastName());
        users.setDateOfBirth(userEditRequest.getDateOfBirth());

        if (passwordEncoder.matches(userEditRequest.getPassword(), users.getPassword())){
            if (!passwordEncoder.matches(userEditRequest.getPasswordNew(), users.getPassword())){
                users.setPassword(passwordEncoder.encode(userEditRequest.getPassword()));
            } else {
                throw new Exception("This password is already has been used");
            }
        } else {
            throw new Exception("Incorrect password");
        }

        Users updateUser = userService.save(users);
        return UserEditResponse.builder()
                .username(updateUser.getUsername())
                .email(updateUser.getEmail())
                .firstName(updateUser.getFirstName())
                .lastName(updateUser.getLastName())
                .dateOfBirth(updateUser.getDateOfBirth())
                .build();
    }

    public UserGetResponse sendGetResponse(long id) {
        Users users = userService.findById(id);

        return UserGetResponse.builder()
                .username(users.getUsername())
                .dateOfBirth(users.getDateOfBirth())
                .email(users.getEmail())
                .firstName(users.getFirstName())
                .lastName(users.getLastName())
                .build();

    }
}
