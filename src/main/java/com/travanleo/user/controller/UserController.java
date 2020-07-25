package com.travanleo.user.controller;

import com.travanleo.user.CommonResponse;
import com.travanleo.user.dto.*;
import com.travanleo.user.model.User;
import com.travanleo.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PutMapping("/update")
    public CommonResponse updateUser(@RequestBody final UpdateUserRequest request){
        UpdateUserResponse response = new UpdateUserResponse();
        Optional<User> optionalUser = userRepo.findById(request.getUserId());
        User user = optionalUser.get();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        userRepo.save(user);
        response.setMessage("Updated successfully");
        response.setUserList(userRepo.findAll());
        return new CommonResponse(CommonResponse.SUCCESS_CODE,CommonResponse.SUCCESS, response);
    }

    @DeleteMapping("/delete/{userId}")
    public CommonResponse deleteUser(@PathVariable("userId") Long userId){
        DeleteUserResponse response = new DeleteUserResponse();
        final Optional<User> user = userRepo.findById(userId);
        userRepo.delete(user.get());
        response.setMessage("Deleted successfully");
        return new CommonResponse(CommonResponse.SUCCESS_CODE,CommonResponse.SUCCESS, response);
    }
}
