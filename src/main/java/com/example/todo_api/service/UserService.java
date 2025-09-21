package com.example.todo_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.todo_api.mapper.UserMapper;
import com.example.todo_api.entity.User;
import com.example.todo_api.dto.*;
import com.example.todo_api.form.UserCreateForm;


/**
 * ユーザービジネスロジック
 */
@Service

public class UserService {
    @Autowired
    private UserMapper userMapper;


    /**
     * 登録
     * 
     * @param form
     * @return
     */
    @Transactional
    public UserResponse createUser(UserCreateForm form) {
        User user = new User();
        user.setName(form.getName());
        userMapper.insertUser(user);
        return convertToResponse(user);
    }


    /** Responseに詰め替える */
    private UserResponse convertToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setName(user.getName());
        return response;
    }

}
