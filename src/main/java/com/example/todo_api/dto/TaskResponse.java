package com.example.todo_api.dto;

import java.util.List;
import com.example.todo_api.entity.User; // Userエンティティを直接使う (より丁寧な設計ではUserResponseDTOを作る)
import lombok.Data;


/**
 * タスクのエンティティ
 */

@Data
public class TaskResponse {
    // ID
    private Long id;
    // 名前
    private String title;

    private boolean completed;

    /** このタスクの担当者リスト */
    private List<User> assignees;



}
