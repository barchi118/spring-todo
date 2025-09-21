package com.example.todo_api.form;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザー登録
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateForm {
    // 名前
    @NotBlank
    @Size(max = 255)
    private String name;

}
