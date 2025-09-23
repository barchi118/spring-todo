package com.example.todo_api.form;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
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

}
