package com.example.todo_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 登録データ返還用ResponseEntity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserResponse {
    // USERID
    private Long userId;
    // 名前
    private String name;

}
