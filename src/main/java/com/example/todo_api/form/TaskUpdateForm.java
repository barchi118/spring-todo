package com.example.todo_api.form;

import java.util.List;
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

    @NotNull
    private Integer version;

    /** 紐付ける担当者のIDリスト */
    private List<Long> assigneeIds;

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


}
