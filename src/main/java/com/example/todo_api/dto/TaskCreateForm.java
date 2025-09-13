package com.example.todo_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskCreateForm {
    // 1. フィールドをテーブルのカラムに合わせる
    @NotBlank // null, 空文字, スペースのみを許可しない
    @Size(max = 255) // 最大255文字まで
    private String title;

    @NotNull

    private boolean completed;

    // 2. ゲッターとセッターも修正する
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
