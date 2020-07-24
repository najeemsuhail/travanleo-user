package com.travanleo.user.dto;

import com.travanleo.user.CommonResponse;
import com.travanleo.user.model.User;

import java.util.List;

public class ListUserResponse {
   private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
