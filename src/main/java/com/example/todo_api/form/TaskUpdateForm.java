package com.example.todo_api.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskUpdateForm {
    /**
     * タスクのタイトル。
     */
    @NotBlank
    @Size(max = 255)
    private String title;

    /**
     * タスクの完了状態。
     */
    @NotNull
    private boolean completed;

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
