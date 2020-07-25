package com.travanleo.user.dto;

import com.travanleo.user.model.User;

import java.util.List;

public class UpdateUserResponse {
    private List<User> userList;
private String message;
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
