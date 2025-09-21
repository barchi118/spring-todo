package com.example.todo_api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * UserEntity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // 名前
    private String name;
    // id
    private Long UserId;

}
