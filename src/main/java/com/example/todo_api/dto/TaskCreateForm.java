package com.example.todo_api.dto;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


/**
 * 新規タスク作成リクエストを受け取るためのフォームクラス。
 */

@Data
public class TaskCreateForm {
    // 1. フィールドをテーブルのカラムに合わせる
    @NotBlank // null, 空文字, スペースのみを許可しない
    @Size(max = 255) // 最大255文字まで
    private String title;

    @NotNull

    private boolean completed;
    /** 紐付ける担当者のIDリスト */
    private List<Long> assigneeIds;


}
