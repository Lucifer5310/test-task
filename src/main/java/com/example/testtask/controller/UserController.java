package com.example.testtask.controller;

import com.example.testtask.dto.users.UserEditRequest;
import com.example.testtask.dto.users.UserEditResponse;
import com.example.testtask.dto.users.UserGetResponse;
import com.example.testtask.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping(value = "/{id}")
    public UserGetResponse findById(@PathVariable long id){
        return userFacade.sendGetResponse(id);
    }

    @PutMapping(value = "/{id}")
    public UserEditResponse changeUser(@RequestBody UserEditRequest userEditRequest,
                                       @PathVariable long id) throws Exception {
        return userFacade.saveEditRequest(userEditRequest, id);
    }
}
