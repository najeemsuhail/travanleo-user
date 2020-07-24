package com.travanleo.user.controller;

import com.travanleo.user.CommonResponse;
import com.travanleo.user.dto.CreateUserRequest;
import com.travanleo.user.dto.CreateUserResponse;
import com.travanleo.user.dto.ListUserResponse;
import com.travanleo.user.model.User;
import com.travanleo.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/list")
    public CommonResponse listUser(){
        ListUserResponse response = new ListUserResponse();
        response.setUserList(userRepo.findAll());
        return new CommonResponse(CommonResponse.SUCCESS_CODE,CommonResponse.SUCCESS, response);
    }

    @PostMapping("/create")
    public CommonResponse createUser(@RequestBody final CreateUserRequest request){
        CreateUserResponse response = new CreateUserResponse();
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        userRepo.save(user);
        response.setUserList(userRepo.findAll());
        return new CommonResponse(CommonResponse.SUCCESS_CODE,CommonResponse.SUCCESS, response);
    }
}
